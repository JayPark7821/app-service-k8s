package kr.perfume.authservice.controller;

import kr.perfume.api.ApiResponse;
import kr.perfume.api.composite.auth.AuthController;
import kr.perfume.api.composite.auth.AuthResponseDto;
import kr.perfume.api.composite.auth.JoinRequestDto;
import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.authservice.service.AuthService;
import kr.perfume.utils.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    @Override
    public ResponseEntity<ApiResponse<AuthResponseDto>> login(String provider, String idToken) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(ApiResponse.success(authService.login(provider, idToken)));
    }

    @Override
    public ResponseEntity<ApiResponse<AuthResponseDto>> join(JoinRequestDto requestDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("---------------------- JOIN USER BINDING ERROR --------------------------");
            for (ObjectError allError : bindingResult.getAllErrors()) {
                throw new PerfumeApplicationException(HttpStatus.BAD_REQUEST, allError.getDefaultMessage());
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ApiResponse<>(HttpStatus.CREATED.value(), "CREATED",authService.join(requestDto) ));
    }

}
