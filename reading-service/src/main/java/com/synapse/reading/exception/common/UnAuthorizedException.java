package com.synapse.reading.exception.common;

import com.synapse.common.exception.BusinessException;

public class UnAuthorizedException extends BusinessException {
    private final static int CODE = 1003;

    public UnAuthorizedException(String msg) {
        super(CODE, msg);
    }

    public UnAuthorizedException() {
        super(CODE, "have no right ");
    }

}
