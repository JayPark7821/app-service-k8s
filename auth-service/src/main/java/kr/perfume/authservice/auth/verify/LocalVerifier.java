package kr.perfume.authservice.auth.verify;


import kr.perfume.api.composite.auth.TokenVerifierFactory;
import kr.perfume.authservice.auth.userInfo.LocalUserInfo;
import kr.perfume.api.composite.auth.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class LocalVerifier implements TokenVerifierFactory {


    @Override
    public OAuth2UserInfo verifyTdToken(String token) {

        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("id", "testId");
        attributes.put("name", "테스트 유저");
        attributes.put("email", "test@test.com");
        attributes.put("picture", "testUrl");
        return new LocalUserInfo(attributes);

    }
}
