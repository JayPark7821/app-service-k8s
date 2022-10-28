package kr.perfume.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    INVALID_ID_TOKEN(HttpStatus.UNAUTHORIZED,"Invalid id token" ),
    INVALID_PROVIDER_TYPE(HttpStatus.BAD_REQUEST, "Invalid Provider Type" ),
    USER_ALREADY_JOINED(HttpStatus.BAD_REQUEST,"이미 회원가입된 유저" ),
    INVALID_JOIN_DATA(HttpStatus.BAD_REQUEST, "잘못된 가입 정보 입니다." );


    private HttpStatus status;
    private String message;

}
