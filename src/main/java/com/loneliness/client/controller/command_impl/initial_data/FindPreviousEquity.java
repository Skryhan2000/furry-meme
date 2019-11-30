package com.loneliness.client.controller.command_impl.initial_data;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.InitialData;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.math.BigDecimal;

public class FindPreviousEquity implements Command<InitialData, BigDecimal> {
    @Override
    public BigDecimal execute(InitialData request) throws ControllerException {
        try {
            return FactoryService.getInstance().getInitialDataService().findPreviousEquity(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
