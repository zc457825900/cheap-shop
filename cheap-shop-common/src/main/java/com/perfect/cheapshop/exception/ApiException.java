package com.perfect.cheapshop.exception;

/**
 * 公共异常
 */
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer code;

    public ApiException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
