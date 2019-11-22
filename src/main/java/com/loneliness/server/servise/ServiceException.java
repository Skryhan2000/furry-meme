package com.loneliness.server.servise;

public class ServiceException extends RuntimeException{
    private String message;
    private Throwable cause;

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }

    public ServiceException(String message, Throwable cause) {
        super(message);
        this.message = message;
        this.cause = cause;
    }


    public ServiceException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }
}
