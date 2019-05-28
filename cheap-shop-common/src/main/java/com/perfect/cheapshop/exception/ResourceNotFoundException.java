package com.perfect.cheapshop.exception;

import com.perfect.cheapshop.enums.ApiExceptionCode;

/**
 * 实现真正的异常
 */
public class ResourceNotFoundException  extends ApiException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String msg) {
        super(ApiExceptionCode.RESOURCE_NOT_FOUND.getValue(), msg);
    }
}