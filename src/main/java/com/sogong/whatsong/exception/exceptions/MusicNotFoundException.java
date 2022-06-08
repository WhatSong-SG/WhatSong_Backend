package com.sogong.whatsong.exception.exceptions;

import com.sogong.whatsong.exception.ErrorCode;
import com.sogong.whatsong.exception.GlobalException;

public class MusicNotFoundException extends GlobalException {

    public static final GlobalException EXCEPTION = new MusicNotFoundException();

    private MusicNotFoundException() {
        super(ErrorCode.MUSIC_NOT_FOUND);
    }
}
