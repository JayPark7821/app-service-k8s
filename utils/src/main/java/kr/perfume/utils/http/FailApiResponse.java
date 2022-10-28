package kr.perfume.utils.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import kr.perfume.utils.enums.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class FailApiResponse<T> {

    private final int code;
    private final String message;

    @Builder
    public FailApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> FailApiResponse<T> fail(ErrorCode errorCode ) {
        return new FailApiResponse<T>(errorCode.getStatus().value(), errorCode.getMessage());
    }

    public static <T> FailApiResponse<T> fail(HttpStatus errorCode , String message) {
        return new FailApiResponse<T>(errorCode.value(), message);
    }


}
