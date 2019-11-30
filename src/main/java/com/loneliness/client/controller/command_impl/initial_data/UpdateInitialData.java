package com.loneliness.client.controller.command_impl.initial_data;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.InitialData;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class UpdateInitialData implements Command<InitialData,String> {
    @Override
    public String execute(InitialData request) throws ControllerException {
        try {
            return FactoryService.getInstance().getInitialDataService().update(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
