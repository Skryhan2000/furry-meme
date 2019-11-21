package com.loneliness.server.controller.command_implements;

import com.loneliness.server.controller.Command;

public class WrongCommand implements Command {
    @Override
    public Object execute(Object request) {
        return new Object();
    }
}
