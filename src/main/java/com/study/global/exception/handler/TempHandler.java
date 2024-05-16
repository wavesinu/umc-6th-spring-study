package com.study.global.exception.handler;

import com.study.global.apiPayLoad.code.BaseErrorCode;
import com.study.global.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode code) {
        super(code);
    }
}
