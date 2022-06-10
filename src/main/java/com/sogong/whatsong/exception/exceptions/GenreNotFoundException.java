package com.sogong.whatsong.exception.exceptions;

import com.sogong.whatsong.exception.ErrorCode;
import com.sogong.whatsong.exception.GlobalException;

public class GenreNotFoundException extends GlobalException {

    public static GlobalException EXCEPTION = new GenreNotFoundException();

    private GenreNotFoundException() {
        super(ErrorCode.GENRE_NOT_FOUND);
    }
}
