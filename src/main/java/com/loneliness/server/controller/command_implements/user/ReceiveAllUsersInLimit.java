package com.loneliness.server.controller.command_implements.user;

import com.loneliness.entity.UserData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllUsersInLimit implements Command<int[], Map<Integer, UserData>> {
    @Override
    public Map<Integer, UserData> execute(int[] request) {
        return ServiceFactory.getInstance().getUserService().receiveAllInLimit(request[0],request[1]);
    }
}
