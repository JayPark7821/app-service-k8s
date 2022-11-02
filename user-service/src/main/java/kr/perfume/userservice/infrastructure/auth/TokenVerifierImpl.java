package kr.perfume.userservice.infrastructure.auth;

import java.util.List;

import org.springframework.stereotype.Component;

import kr.perfume.api.composite.auth.OAuth2UserInfo;
import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.userservice.domain.auth.TokenVerifier;
import kr.perfume.utils.enums.ErrorCode;
import kr.perfume.utils.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenVerifierImpl implements TokenVerifier {

	private final List<SocialTokenVerifier> socialTokenVerifierList;

	@Override
	public OAuth2UserInfo verifyToken(ProviderType providerType, String idToken) {
		SocialTokenVerifier socialTokenVerifier = routeSocialVerifier(providerType);
		return socialTokenVerifier.verifyToken(idToken);
	}
	
	private SocialTokenVerifier routeSocialVerifier(ProviderType providerType) {
		return socialTokenVerifierList.stream()
			.filter(socialTokenVerifier -> socialTokenVerifier.support(providerType))
			.findFirst()
			.orElseThrow(() -> new PerfumeApplicationException(ErrorCode.NOT_SUPPORTED_SOCIAL_TYPE));
	}
}
