package com.beStrong.exceptions;

/**
 * Created by roy on 2017/3/24.
 */
public class SportException extends RuntimeException {

    public SportException() {
    }

    public SportException(String message) {
        super(message);
    }

    public SportException(String message, Throwable cause) {
        super(message, cause);
    }

    public SportException(Throwable cause) {
        super(cause);
    }

    public SportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
