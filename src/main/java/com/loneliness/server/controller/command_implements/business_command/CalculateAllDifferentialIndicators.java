package com.loneliness.server.controller.command_implements.business_command;

import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.Index;
import com.loneliness.server.controller.Command;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.servise.ServiceException;
import com.loneliness.server.servise.ServiceFactory;

public class CalculateAllDifferentialIndicators implements Command<Index, DifferentialIndicators> {
    @Override
    public DifferentialIndicators execute(Index request) throws ControllerException {
        try {
            return ServiceFactory.getInstance().getBusinessService().calculateAllDifferentialIndicators(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
