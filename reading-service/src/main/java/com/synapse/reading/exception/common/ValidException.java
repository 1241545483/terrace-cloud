package com.synapse.reading.exception.common;

import com.synapse.common.exception.BusinessException;

/**
 * 字段校验异常
 */
public class ValidException extends BusinessException {

    private final static int CODE = 1002;

    public ValidException(String msg) {
        super(CODE, msg);
    }
}
