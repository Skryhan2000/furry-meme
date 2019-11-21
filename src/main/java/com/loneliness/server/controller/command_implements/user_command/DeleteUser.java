package com.loneliness.server.controller.command_implements.user_command;

import com.loneliness.entity.UserData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class DeleteUser implements Command<UserData,String> {
    @Override
    public String execute(UserData request) {
        return ServiceFactory.getInstance().getUserService().delete(request);
    }
}
