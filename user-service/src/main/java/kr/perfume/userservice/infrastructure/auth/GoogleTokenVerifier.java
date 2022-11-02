package kr.perfume.userservice.infrastructure.auth;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.userservice.infrastructure.auth.user.GoogleOAuth2UserInfo;
import kr.perfume.userservice.infrastructure.auth.user.OAuth2UserInfo;
import kr.perfume.utils.enums.ErrorCode;
import kr.perfume.utils.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class GoogleTokenVerifier implements SocialTokenVerifier {

	@Value("${google.clientId}")
	private String clientId;
	private final NetHttpTransport transport = new NetHttpTransport();
	private final JsonFactory jsonFactory = new GsonFactory();

	@Override
	public boolean support(ProviderType providerType) {
		return ProviderType.GOOGLE == providerType;
	}

	@Override
	public OAuth2UserInfo verifyToken(String idToken) {
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
			.setIssuers(Arrays.asList("https://accounts.google.com", "accounts.google.com"))
			.setAudience(Collections.singletonList(clientId))
			.build();

		GoogleIdToken token = null;
		try {
			token = verifier.verify(idToken);
		} catch (GeneralSecurityException e) {
			throw new PerfumeApplicationException(ErrorCode.INVALID_ID_TOKEN);
		} catch (IOException e) {
			throw new PerfumeApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
		}
		if (token != null) {
			GoogleIdToken.Payload payload = token.getPayload();
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("id", payload.getSubject());
			attributes.put("name", payload.get("name"));
			attributes.put("email", payload.get("email"));
			attributes.put("picture", payload.get("picture"));
			return new GoogleOAuth2UserInfo(attributes);

		} else {
			throw new PerfumeApplicationException(ErrorCode.INVALID_ID_TOKEN);
		}
	}
}
