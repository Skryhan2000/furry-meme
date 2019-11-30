package com.loneliness.client.controller.command_impl.dividend;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Dividend;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class CreateDividend implements Command <Dividend,String>{
    @Override
    public String execute(Dividend request) throws ControllerException {
        try {
            return FactoryService.getInstance().getDividendService().create(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
