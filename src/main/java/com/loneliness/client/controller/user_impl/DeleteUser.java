package com.loneliness.client.controller.user_impl;

import com.loneliness.client.service.FactoryService;
import com.loneliness.entity.UserData;
import com.loneliness.client.controller.Command;

public class DeleteUser implements Command<UserData,String> {
    @Override
    public String execute(UserData request) {
        return FactoryService.getInstance().getUserService().delete(request);
    }
}
