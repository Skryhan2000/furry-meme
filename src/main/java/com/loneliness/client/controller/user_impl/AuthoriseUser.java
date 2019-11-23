package com.loneliness.client.controller.user_impl;

import com.loneliness.client.controller.Command;
import com.loneliness.client.service.FactoryService;
import com.loneliness.entity.UserData;


public class AuthoriseUser implements Command<UserData,UserData.Type> {
    @Override
    public UserData.Type execute(UserData request) {
        return FactoryService.getInstance().getUserService().authorise(request);
    }
}
