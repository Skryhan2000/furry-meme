package com.loneliness.client.controller.command_impl.user;

import com.loneliness.client.controller.Command;
import com.loneliness.client.service.FactoryService;
import com.loneliness.entity.UserData;


public class CreateUser implements Command<UserData,String> {
    @Override
    public String execute(UserData request) {
        return FactoryService.getInstance().getUserService().create(request);
    }
}
