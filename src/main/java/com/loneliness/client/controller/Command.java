package com.loneliness.client.controller;

public interface Command <D,R> {
    R execute(D request) throws ControllerException;
}
