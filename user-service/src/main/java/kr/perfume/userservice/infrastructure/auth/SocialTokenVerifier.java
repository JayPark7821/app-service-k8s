package kr.perfume.userservice.infrastructure.auth;

import kr.perfume.api.composite.auth.OAuth2UserInfo;
import kr.perfume.api.core.enums.ProviderType;

public interface SocialTokenVerifier {

	boolean support(ProviderType providerType);

	OAuth2UserInfo verifyToken(String idToken);

}
