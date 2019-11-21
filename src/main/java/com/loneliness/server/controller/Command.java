package com.loneliness.server.controller;

public interface Command <D,R> {
    R execute(D request);
}
