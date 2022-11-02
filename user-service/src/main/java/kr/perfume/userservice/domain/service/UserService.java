package kr.perfume.userservice.domain.service;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.userservice.domain.UserInfo;
import kr.perfume.userservice.domain.UserJoinCommand;

public interface UserService {
	UserInfo.Main getUserByUserToken(String userToken);

	UserInfo.LoginInfo login(ProviderType provider, String idToken);

	UserInfo.LoginInfo join(UserJoinCommand userJoinCommand);
}
