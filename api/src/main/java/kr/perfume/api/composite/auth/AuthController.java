package kr.perfume.api.composite.auth;

import kr.perfume.api.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface AuthController {

    @GetMapping("/login/{provider}/{idToken}")
    ResponseEntity<ApiResponse<AuthResponseDto>> login(@PathVariable("provider") String provider,
                                                       @PathVariable("idToken") String idToken);

}
