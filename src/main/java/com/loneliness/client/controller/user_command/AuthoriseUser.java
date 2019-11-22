package com.loneliness.client.controller.user_command;

import com.loneliness.client.controller.Command;
import com.loneliness.client.servise.FactoryService;
import com.loneliness.entity.UserData;


public class AuthoriseUser implements Command<UserData,UserData.Type> {
    @Override
    public UserData.Type execute(UserData request) {
        return FactoryService.getInstance().getUserService().authorise(request);
    }
}
