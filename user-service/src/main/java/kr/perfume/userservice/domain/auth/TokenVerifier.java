package kr.perfume.userservice.domain.auth;

import kr.perfume.api.composite.auth.OAuth2UserInfo;
import kr.perfume.api.core.enums.ProviderType;

public interface TokenVerifier {

	OAuth2UserInfo verifyToken(ProviderType providerType, String idToken);
}
