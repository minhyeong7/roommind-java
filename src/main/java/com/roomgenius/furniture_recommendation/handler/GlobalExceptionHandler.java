package com.roomgenius.furniture_recommendation.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 🌐 전역 예외 처리 핸들러
 * - DTO 유효성 검증 실패, IllegalArgumentException 등
 * - 리액트로 깔끔한 JSON 응답 반환
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /** ✅ DTO 유효성 검증 실패 시 (예: 이메일, 비밀번호 형식 오류) */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("success", false);

        // 모든 필드 오류 중 첫 번째만 표시 (원하면 반복문으로 여러 개 가능)
        FieldError fieldError = ex.getBindingResult().getFieldErrors().get(0);
        errorResponse.put("message", fieldError.getDefaultMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /** ✅ IllegalArgumentException (예: 이메일 중복 등) */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("success", false);
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /** ✅ 기타 예상치 못한 서버 오류 */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("success", false);
        error.put("message", "서버 내부 오류가 발생했습니다.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
