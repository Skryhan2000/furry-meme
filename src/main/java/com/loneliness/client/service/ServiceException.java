package com.loneliness.client.service;

public class ServiceException extends Throwable{
    private String userMessage;
    public ServiceException(String message,String userMessage) {
        super(message);
        this.userMessage=userMessage;
    }

    public ServiceException(String message, Throwable cause,String userMessage) {
        super(message, cause);
        this.userMessage=userMessage;
    }

    public ServiceException(Throwable cause,String userMessage) {
        super(userMessage, cause);
        this.userMessage=userMessage;
    }
}
