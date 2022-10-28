package kr.perfume.authservice.service;

import kr.perfume.api.composite.auth.AuthResponseDto;
import kr.perfume.api.composite.auth.JoinRequestDto;
import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.api.core.tempuser.TempUserDto;
import kr.perfume.api.core.user.UserDto;
import kr.perfume.authservice.Integration.AuthCompositeIntegration;
import kr.perfume.api.composite.auth.OAuth2UserInfo;
import kr.perfume.authservice.auth.verify.AppleVerifier;
import kr.perfume.authservice.auth.verify.GoogleVerifier;
import kr.perfume.authservice.auth.verify.LocalVerifier;
import kr.perfume.utils.enums.ErrorCode;
import kr.perfume.utils.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthCompositeIntegration authCompositeIntegration;
    private final GoogleVerifier googleVerifier;
    private final AppleVerifier appleVerifier;
    private final LocalVerifier localVerifier;
    private final BCryptPasswordEncoder passwordEncoder;
    private final static String LOGIN = "login";
    private final static String JOIN = "join";

    public AuthResponseDto login(String provider, String idToken) {
        ProviderType providerType = ProviderType.of(provider);
        OAuth2UserInfo userInfo = verifyToken(providerType, idToken);

        UserDto savedUser = authCompositeIntegration.getUserByEmail(idToken);

        if (checkJoinOrLogin(savedUser, providerType).equals(LOGIN)) {
            return genLoginUserDto(savedUser);
        } else {
            TempUserDto tempUserDto = savePreJoinUser(userInfo, providerType);
            return new AuthResponseDto(tempUserDto);
        }
    }

    public AuthResponseDto join(JoinRequestDto requestDto) {
        UserDto savedUser = authCompositeIntegration.getUserByEmail(requestDto.getEmail());
        if (savedUser != null) {
            throw new PerfumeApplicationException(ErrorCode.USER_ALREADY_JOINED);
        }

        TempUserDto tempUser = authCompositeIntegration.getTempUserByTempUserId(requestDto.getTempUserId());
        if (tempUser == null) {
            throw new PerfumeApplicationException(ErrorCode.INVALID_JOIN_DATA);
        }

        if (requestDto.getEmail() != tempUser.getEmail()) {
            throw new PerfumeApplicationException(ErrorCode.INVALID_JOIN_DATA);
        }

        UserDto user = UserDto.builder()
            .userId(tempUser.getUserId())
            .email(tempUser.getEmail())
            .name(tempUser.getUsername())
            .profileImage(tempUser.getProfileImageUrl())
            .providerType(tempUser.getProviderType())
            .password(generateTempPw())
            .build();

        if (authCompositeIntegration.saveUser(user) !=null) {
            return new AuthResponseDto(user, "access-token", "refresh-token");
        } else {
            throw new PerfumeApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private AuthResponseDto genLoginUserDto(UserDto savedUser) {
        String accessToken = "access-abcdefg";
        String refreshToken = "refresh-abcdefg";

        return new AuthResponseDto(savedUser, accessToken, refreshToken);
    }

    private TempUserDto savePreJoinUser(OAuth2UserInfo userInfo, ProviderType providerType) {
        String uuid = UUID.randomUUID().toString();
        return authCompositeIntegration.forceSaveTempUser(new TempUserDto(uuid, userInfo, providerType ));
    }

    private OAuth2UserInfo verifyToken(ProviderType provider, String token) {
        switch (provider) {
            case GOOGLE:
                return googleVerifier.verifyTdToken(token);
            case APPLE:
                return appleVerifier.verifyTdToken(token);
            case LOCAL:
                return localVerifier.verifyTdToken(token);
            default:
                throw new PerfumeApplicationException(ErrorCode.INVALID_PROVIDER_TYPE);
        }
    }

    private String checkJoinOrLogin(UserDto userInfo, ProviderType providerType) {

        if (userInfo != null) {
            if (providerType != userInfo.getProviderType()) {
                throw new PerfumeApplicationException(HttpStatus.BAD_REQUEST,
                        "Looks like you're signed up with " + providerType +
                                " account. Please use your " + userInfo.getProviderType() + " account to login."
                );
            }
            return LOGIN;
        } else {
            return JOIN;
        }
    }

    private String generateTempPw() {
        return passwordEncoder.encode(UUID.randomUUID().toString());
    }
}
