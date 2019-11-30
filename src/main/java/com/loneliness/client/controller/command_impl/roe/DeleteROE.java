package com.loneliness.client.controller.command_impl.roe;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.ROE;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class DeleteROE implements Command<ROE,String> {
    @Override
    public String execute(ROE request) throws ControllerException {
        try {
            return FactoryService.getInstance().getRoeService().delete(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
