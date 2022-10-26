package kr.perfume.authservice.controller;

import kr.perfume.api.ApiResponse;
import kr.perfume.api.composite.auth.AuthController;
import kr.perfume.api.composite.auth.AuthResponseDto;
import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    @Override
    public ResponseEntity<ApiResponse<AuthResponseDto>> login(String provider, String idToken) {
        authService.login(provider, idToken);
        return null;
    }
}
