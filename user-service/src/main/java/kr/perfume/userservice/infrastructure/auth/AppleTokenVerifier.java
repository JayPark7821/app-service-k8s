package kr.perfume.userservice.infrastructure.auth;

import org.springframework.stereotype.Component;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.userservice.infrastructure.auth.user.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppleTokenVerifier implements SocialTokenVerifier {

	@Override
	public boolean support(ProviderType providerType) {
		return ProviderType.APPLE == providerType;
	}

	@Override
	public OAuth2UserInfo verifyToken(String idToken) {
		return null;
	}
}
