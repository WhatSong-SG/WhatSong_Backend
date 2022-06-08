package com.sogong.whatsong.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ErrorResponse {

    private final String message;
    private final Integer status;
    private final LocalDateTime timestamp;
    private final String description;

    public static ErrorResponse of(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .message(errorCode.getMessage())
                .status(errorCode.getStatus())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
