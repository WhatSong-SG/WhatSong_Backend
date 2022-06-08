package com.sogong.whatsong.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    INVALID_PARAMETER(400, "Invalid Parameter"),
    MUSIC_NOT_FOUND(404, "Music Not Found"),
    METHOD_NOT_ALLOWED(405, "Mehtod Not Allowed"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final Integer status;
    private final String message;

    ErrorCode(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
