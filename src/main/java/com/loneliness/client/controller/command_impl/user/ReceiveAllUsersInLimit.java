package com.loneliness.client.controller.command_impl.user;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.UserData;


import java.util.Map;

public class ReceiveAllUsersInLimit implements Command<int[], Map<Integer, UserData>> {
    @Override
    public Map<Integer, UserData> execute(int[] request) throws ControllerException {
        try {
            return FactoryService.getInstance().getUserService().receiveAllElemInLimit(request[0],request[1]);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
