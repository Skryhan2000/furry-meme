package com.loneliness.server.controller.command_implements.business;

import com.loneliness.entity.InitialData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.servise.ServiceException;
import com.loneliness.server.servise.ServiceFactory;

import java.math.BigDecimal;

public class CalculateProfitability implements Command<InitialData, BigDecimal> {
    @Override
    public BigDecimal execute(InitialData request) throws ControllerException {
        try {
            return ServiceFactory.getInstance().getBusinessService().calculateProfitability(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
