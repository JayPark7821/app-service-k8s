package kr.perfume.userservice.domain.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.userservice.domain.PreJoinUser;
import kr.perfume.userservice.domain.User;
import kr.perfume.userservice.domain.UserInfo;
import kr.perfume.userservice.domain.UserJoinCommand;
import kr.perfume.userservice.domain.auth.TokenVerifier;
import kr.perfume.userservice.domain.reader.PreJoinUserReader;
import kr.perfume.userservice.domain.reader.UserReader;
import kr.perfume.userservice.domain.sotre.PreJoinUserStore;
import kr.perfume.userservice.domain.sotre.UserStore;
import kr.perfume.userservice.infrastructure.auth.user.OAuth2UserInfo;
import kr.perfume.utils.enums.ErrorCode;
import kr.perfume.utils.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserReader userReader;
	private final UserStore userStore;
	private final PreJoinUserStore preJoinUserStore;
	private final PreJoinUserReader preJoinUserReader;
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
			PreJoinUser preJoinUser = savePreJoinUser(userInfo, provider);
			return new UserInfo.LoginInfo(preJoinUser);
		}
	}

	@Override
	public UserInfo.LoginInfo join(UserJoinCommand userJoinCommand) {
		PreJoinUser preJoinUser = validateJoinParam(userJoinCommand);
		User user = preJoinUser.toUser();

		return genLoginUserDto(user);
	}

	private PreJoinUser validateJoinParam(UserJoinCommand userJoinCommand) {
		if (userReader.findUserByEmail(userJoinCommand.getEmail()).isPresent()) {
			throw new PerfumeApplicationException(ErrorCode.USER_ALREADY_JOINED);
		}
		return preJoinUserReader.findPreJoinUserByUuidAndEmail(
				userJoinCommand.getPreJoinUserId(), userJoinCommand.getEmail())
			.orElseThrow(() -> new PerfumeApplicationException(ErrorCode.INVALID_JOIN_DATA));
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

	private PreJoinUser savePreJoinUser(OAuth2UserInfo userInfo, ProviderType providerType) {
		LocalDateTime now = LocalDateTime.now();
		String uuid = UUID.randomUUID().toString();
		PreJoinUser user = new PreJoinUser(
			uuid,
			userInfo.getId(),
			userInfo.getName(),
			userInfo.getEmail(),
			providerType,
			userInfo.getImageUrl()
		);

		return preJoinUserStore.store(user);
	}

}
