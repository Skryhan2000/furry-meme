package com.loneliness.server.controller.command_implements.business;

import com.loneliness.entity.ROE;
import com.loneliness.server.controller.Command;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.servise.ServiceFactory;

public class GetState implements Command<ROE, String> {
    @Override
    public String execute(ROE request) throws ControllerException {
        return ServiceFactory.getInstance().getBusinessService().state(request);
    }
}
