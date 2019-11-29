package com.loneliness.server.controller.command_implements.business_command;

import com.loneliness.entity.Index;
import com.loneliness.entity.ROE;
import com.loneliness.server.controller.Command;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.servise.ServiceException;
import com.loneliness.server.servise.ServiceFactory;

import java.math.BigDecimal;

public class CalculateROE implements Command<ROE, BigDecimal> {
    @Override
    public BigDecimal execute(ROE request) throws ControllerException {
        try {
            return ServiceFactory.getInstance().getBusinessService().calculateROE(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
