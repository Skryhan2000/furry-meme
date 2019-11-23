package com.loneliness.client.controller.command_impl.user;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.UserData;
import com.loneliness.client.controller.Command;

public class DeleteUser implements Command<UserData,String> {
    @Override
    public String execute(UserData request) throws ControllerException {
        try {
            return FactoryService.getInstance().getUserService().delete(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
