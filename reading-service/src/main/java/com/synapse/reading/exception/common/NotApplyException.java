package com.synapse.reading.exception.common;

import com.synapse.common.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "请先报名，再参与！")
public class NotApplyException extends BusinessException {


    private final static int CODE = 403;

    public NotApplyException() {
        super(CODE, "请先报名，再参与！");
    }

    public NotApplyException(int code, String msg) {
        super(code, msg);
    }
}
