package com.loneliness.server.controller.command_implements.user_command;

import com.loneliness.entity.UserData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class AuthoriseUser implements Command<UserData,UserData.Type> {
    @Override
    public UserData.Type execute(UserData request) {
        return ServiceFactory.getInstance().getUserService().authorise(request);
    }
}
