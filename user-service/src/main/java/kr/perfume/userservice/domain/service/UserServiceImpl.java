package kr.perfume.userservice.domain.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.perfume.api.composite.auth.AuthResponseDto;
import kr.perfume.api.composite.auth.OAuth2UserInfo;
import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.userservice.domain.User;
import kr.perfume.userservice.domain.UserInfo;
import kr.perfume.userservice.domain.auth.TokenVerifier;
import kr.perfume.userservice.domain.reader.UserReader;
import kr.perfume.utils.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserReader userReader;
	private final TokenVerifier tokenVerifier;

	@Override
	public UserInfo.Main getUserByUserToken(String userToken) {
		User user = userReader.getUserByUserToken(userToken);
		return new UserInfo.Main(user);
	}

	@Override
	public UserInfo.LoginInfo login(ProviderType provider, String idToken) {
		OAuth2UserInfo userInfo = tokenVerifier.verifyToken(provider, idToken);
		Optional<User> user = userReader.findUserByEmail(userInfo.getEmail());

		if (isUserJoinning(user, provider)) {
			return genLoginUserDto(user.get());
		} else {
			TempUserDto tempUserDto = savePreJoinUser(userInfo, providerType);
			return new AuthResponseDto(tempUserDto);
		}
	}

	private UserInfo.LoginInfo genLoginUserDto(User loginUser) {
		String accessToken = "access-abcdefg";
		String refreshToken = "refresh-abcdefg";
		return new UserInfo.LoginInfo(loginUser, accessToken, refreshToken);
	}

	private boolean isUserJoinning(Optional<User> user, ProviderType provider) {

		if (user.isPresent()) {
			if (provider != user.get().getProviderType()) {
				throw new PerfumeApplicationException(HttpStatus.BAD_REQUEST,
					"Looks like you're signed up with " + provider +
						" account. Please use your " + user.get().getProviderType() + " account to login."
				);
			}
			return false;
		} else {
			return true;
		}
	}

}
