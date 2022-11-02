package kr.perfume.utils.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
	INVALID_ID_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid id token"),
	INVALID_PROVIDER_TYPE(HttpStatus.BAD_REQUEST, "Invalid Provider Type"),
	USER_ALREADY_JOINED(HttpStatus.BAD_REQUEST, "이미 회원가입된 유저"),
	INVALID_JOIN_DATA(HttpStatus.BAD_REQUEST, "잘못된 가입 정보 입니다."),
	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."), NOT_SUPPORTED_SOCIAL_TYPE(HttpStatus.BAD_REQUEST,
		"지원하지 않는 소셜 타입 입니다."), INVALID_PARAM(HttpStatus.BAD_REQUEST, "올바른 요청값이 아닙니다.");

	private HttpStatus status;
	private String message;

}
