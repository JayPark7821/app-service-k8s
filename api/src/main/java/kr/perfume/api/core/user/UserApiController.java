package kr.perfume.api.core.user;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kr.perfume.api.ApiResponse;

public interface UserApiController {

	@GetMapping("/{userToken}")
	ResponseEntity<ApiResponse<UserDto.UserResponse>> getUserByUserToken(@PathVariable("userToken") String userToken);

	@GetMapping("/login/{provider}/{idToken}")
	ResponseEntity<ApiResponse<UserDto.LoginResponse>> login(@PathVariable("provider") String provider,
		@PathVariable("idToken") String idToken);

	@PostMapping("/join")
	ResponseEntity<ApiResponse<UserDto.LoginResponse>> join(@RequestBody UserDto.JoinRequest requestDto,
		BindingResult bindingResult);
}
