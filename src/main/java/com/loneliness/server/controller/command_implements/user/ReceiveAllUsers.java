package com.loneliness.server.controller.command_implements.user;

import com.loneliness.entity.UserData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllUsers implements Command<Void, Map<Integer, UserData>> {
    @Override
    public Map<Integer, UserData> execute(Void request) {
        return ServiceFactory.getInstance().getUserService().receiveAll();
    }
}
