package com.loneliness.client.controller.command_impl.credit;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Credit;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class ReceiveCredit implements Command<Credit,Credit> {
    @Override
    public Credit execute(Credit request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCreditService().receive(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
