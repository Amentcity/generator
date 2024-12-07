package com.example.maker.meta;

/**
 * 元信息异常
 */
public class MetaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }
}
