package com.loneliness.client.controller.user_impl;

import com.loneliness.client.controller.Command;
import com.loneliness.client.service.FactoryService;
import com.loneliness.entity.UserData;


import java.util.Map;

public class ReceiveAllUsersInLimit implements Command<int[], Map<Integer, UserData>> {
    @Override
    public Map<Integer, UserData> execute(int[] request) {
        return FactoryService.getInstance().getUserService().receiveAllElemInLimit(request[0],request[1]);
    }
}
