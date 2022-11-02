package kr.perfume.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.perfume.api.ApiResponse;
import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.api.core.user.UserApiController;
import kr.perfume.api.core.user.UserDto;
import kr.perfume.userservice.domain.UserInfo;
import kr.perfume.userservice.domain.facade.UserFacade;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserApiControllerImpl implements UserApiController {

	private final UserFacade userFacade;

	@Override
	public ResponseEntity<ApiResponse<UserDto.UserResponse>> getUserByUserToken(String userToken) {
		UserInfo.Main userInfo = userFacade.getUserByUserToken(userToken);
		UserDto.UserResponse userResponse = userInfo.toResponse();

		return ResponseEntity.status(HttpStatus.OK)
			.body(ApiResponse.success(userResponse));
	}

	@Override
	public ResponseEntity<ApiResponse<UserDto.LoginResponse>> login(String provider, String idToken) {
		ProviderType providerType = ProviderType.of(provider);
		userFacade.login(providerType, idToken);
		return null;
	}

	@Override
	public ResponseEntity<ApiResponse<UserDto.LoginResponse>> join(UserDto.JoinRequest requestDto,
		BindingResult bindingResult) {
		return null;
	}

}
