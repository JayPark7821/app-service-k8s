package kr.perfume.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    INVALID_ID_TOKEN(HttpStatus.UNAUTHORIZED,"Invalid id token" ),
    INVALID_PROVIDER_TYPE(HttpStatus.BAD_REQUEST, "Invalid Provider Type" );


    private HttpStatus status;
    private String message;

}
