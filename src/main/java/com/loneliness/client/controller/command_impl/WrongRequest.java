package com.loneliness.client.controller.command_impl;

import com.loneliness.client.controller.Command;

public class WrongRequest implements Command {
    @Override
    public Object execute(Object request) {
        return new Object();
    }
}
