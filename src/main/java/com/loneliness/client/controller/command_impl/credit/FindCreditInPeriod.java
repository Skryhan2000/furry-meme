package com.loneliness.client.controller.command_impl.credit;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.server.servise.ServiceFactory;

import java.math.BigDecimal;

public class FindCreditInPeriod implements Command<Integer,BigDecimal> {
    @Override
    public BigDecimal execute(Integer request) throws ControllerException {
        try {
            return FactoryService.getInstance().getInitialDataService().findCreditInPeriod(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}

