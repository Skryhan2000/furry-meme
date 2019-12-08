package com.loneliness.client.controller;

public class ControllerException extends Throwable{
    private String clientMessage;


    public ControllerException(String message, String clientMessage) {
        super(message);
        this.clientMessage = clientMessage;
    }

    public ControllerException(String message, Throwable cause, String clientMessage) {
        super(message);
        this.clientMessage = clientMessage;

    }


    public ControllerException(Throwable cause) {
        super(cause);
    }

    public ControllerException(Throwable cause, String clientMessage) {
        super(clientMessage,cause);
        this.clientMessage = clientMessage;
    }

    @Override
    public String getMessage() {
        return clientMessage;
    }

    public void setClientMessage(String clientMessage) {
        this.clientMessage = clientMessage;
    }

}
