package com.loneliness.client.controller.command_impl.dividend;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Dividend;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class ReceiveDividend implements Command<Dividend,Dividend> {
    @Override
    public Dividend execute(Dividend request) throws ControllerException {
        try {
            return FactoryService.getInstance().getDividendService().receive(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
