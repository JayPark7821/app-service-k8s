package kr.perfume.userservice.infrastructure.auth;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.userservice.infrastructure.auth.user.OAuth2UserInfo;

public interface SocialTokenVerifier {

	boolean support(ProviderType providerType);

	OAuth2UserInfo verifyToken(String idToken);

}
