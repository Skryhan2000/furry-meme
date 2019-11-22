package com.loneliness.client.controller.user_command;

import com.loneliness.client.controller.Command;
import com.loneliness.client.servise.FactoryService;
import com.loneliness.entity.UserData;

public class ReceiveUser implements Command<UserData,UserData> {
    @Override
    public UserData execute(UserData request) {
        return FactoryService.getInstance().getUserService().receive(request);
    }
}
