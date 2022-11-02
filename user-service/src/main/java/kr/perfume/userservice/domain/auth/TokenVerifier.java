package kr.perfume.userservice.domain.auth;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.userservice.infrastructure.auth.user.OAuth2UserInfo;

public interface TokenVerifier {

	OAuth2UserInfo verifyToken(ProviderType providerType, String idToken);
}
