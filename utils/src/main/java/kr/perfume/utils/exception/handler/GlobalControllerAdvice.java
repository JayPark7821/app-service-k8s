package kr.perfume.utils.exception.handler;

import kr.perfume.utils.exception.PerfumeApplicationException;
import kr.perfume.utils.http.FailApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE) // 우선순위를 가장 높게
@RestControllerAdvice
public class GlobalControllerAdvice {

    private ResponseEntity<FailApiResponse<Void>> buildResponseEntity(HttpStatus errorCode, String message) {
        return ResponseEntity.status(errorCode)
                .body(FailApiResponse.fail(errorCode, message));
    }

    @ExceptionHandler(PerfumeApplicationException.class)
    public ResponseEntity<FailApiResponse<Void>> handleOkrApplicationException(PerfumeApplicationException ex) {
        return buildResponseEntity(ex.getErrorCode(), ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<FailApiResponse<Void>> applicationHandler(RuntimeException ex) {
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}