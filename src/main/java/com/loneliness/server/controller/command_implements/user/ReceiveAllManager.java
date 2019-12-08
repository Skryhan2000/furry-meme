package com.loneliness.server.controller.command_implements.user;

import com.loneliness.entity.Transmission;
import com.loneliness.entity.UserData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllManager implements Command<Transmission, Map<Integer, UserData>> {
    @Override
    public Map<Integer, UserData> execute(Transmission request) {
        return ServiceFactory.getInstance().getUserService().receiveAllManager();
    }
}
