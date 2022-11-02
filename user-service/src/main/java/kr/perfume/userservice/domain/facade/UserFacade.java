package kr.perfume.userservice.domain.facade;

import org.springframework.stereotype.Component;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.userservice.domain.UserInfo;
import kr.perfume.userservice.domain.UserJoinCommand;
import kr.perfume.userservice.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserFacade {
	private final UserService userService;

	public UserInfo.Main getUserByUserToken(String userToken) {
		return userService.getUserByUserToken(userToken);
	}

	public UserInfo.LoginInfo login(ProviderType provider, String idToken) {
		return userService.login(provider, idToken);
	}

	public UserInfo.LoginInfo join(UserJoinCommand userJoinCommand) {
		return userService.join(userJoinCommand);
	}
}
