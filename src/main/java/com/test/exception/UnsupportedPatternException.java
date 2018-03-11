package com.test.exception;

/**
 * Created by rkamat on 3/10/2018.
 */
public class UnsupportedPatternException extends RuntimeException {
    public UnsupportedPatternException() {
    }

    public UnsupportedPatternException(String message) {
        super(message);
    }

    public UnsupportedPatternException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedPatternException(Throwable cause) {
        super(cause);
    }

    public UnsupportedPatternException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
