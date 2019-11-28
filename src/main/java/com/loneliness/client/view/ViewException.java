package com.loneliness.client.view;

public class ViewException extends Throwable{
    private String clientMessage;


    public ViewException(String message, String clientMessage) {
        super(message);
        this.clientMessage = clientMessage;
    }

    public ViewException(String message, Throwable cause, String clientMessage) {
        super(message);
        this.clientMessage = clientMessage;

    }


    public ViewException(Throwable cause) {
        super(cause);
    }

    public ViewException(Throwable cause, String clientMessage) {
        super(cause);
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
