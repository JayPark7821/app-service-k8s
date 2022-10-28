package kr.perfume.authservice.auth.verify;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import kr.perfume.api.composite.auth.TokenVerifierFactory;
import kr.perfume.authservice.auth.userInfo.GoogleOAuth2UserInfo;
import kr.perfume.api.composite.auth.OAuth2UserInfo;
import kr.perfume.utils.enums.ErrorCode;
import kr.perfume.utils.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GoogleVerifier implements TokenVerifierFactory {
    @Value("${google.clientId}")
    private String clientId;
    private final NetHttpTransport transport = new NetHttpTransport();
    private final JsonFactory jsonFactory = new GsonFactory();

    @Override
    public OAuth2UserInfo verifyTdToken(String token) {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setIssuers(Arrays.asList("https://accounts.google.com", "accounts.google.com"))
                .setAudience(Collections.singletonList(clientId))
                .build();

        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(token);
        } catch (GeneralSecurityException e) {
            throw new PerfumeApplicationException(ErrorCode.INVALID_ID_TOKEN);
        } catch (IOException e) {
            throw new PerfumeApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();
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
