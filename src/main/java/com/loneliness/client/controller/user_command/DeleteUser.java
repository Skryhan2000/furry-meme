package com.loneliness.client.controller.user_command;

import com.loneliness.client.servise.FactoryService;
import com.loneliness.entity.UserData;
import com.loneliness.client.controller.Command;

public class DeleteUser implements Command<UserData,String> {
    @Override
    public String execute(UserData request) {
        return FactoryService.getInstance().getUserService().delete(request);
    }
}
