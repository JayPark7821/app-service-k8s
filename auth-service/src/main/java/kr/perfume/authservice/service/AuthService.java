package kr.perfume.authservice.service;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.api.core.user.UserDto;
import kr.perfume.authservice.Integration.AuthCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthCompositeIntegration authCompositeIntegration;

    public void login(ProviderType providerType, String idToken) {
        UserDto userByEmail = authCompositeIntegration.getUserByEmail(idToken);
        System.out.println("userByEmail = " + userByEmail);
    }
}
