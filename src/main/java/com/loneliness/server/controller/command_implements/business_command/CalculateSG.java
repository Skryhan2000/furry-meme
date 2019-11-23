package com.loneliness.server.controller.command_implements.business_command;

import com.loneliness.entity.Index;
import com.loneliness.server.controller.Command;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.servise.ServiceFactory;

import java.math.BigDecimal;

public class CalculateSG implements Command<Index, BigDecimal> {
    @Override
    public BigDecimal execute(Index request) throws ControllerException {
        return ServiceFactory.getInstance().getBusinessService().calculateSG(request);
    }
}
