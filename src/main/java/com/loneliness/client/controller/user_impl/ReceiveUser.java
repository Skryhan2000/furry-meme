package com.loneliness.client.controller.user_impl;

import com.loneliness.client.controller.Command;
import com.loneliness.client.service.FactoryService;
import com.loneliness.entity.UserData;

public class ReceiveUser implements Command<UserData,UserData> {
    @Override
    public UserData execute(UserData request) {
        return FactoryService.getInstance().getUserService().receive(request);
    }
}
