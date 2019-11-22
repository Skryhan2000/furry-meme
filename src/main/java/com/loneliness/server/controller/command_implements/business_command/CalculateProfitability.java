package com.loneliness.server.controller.command_implements.business_command;

import com.loneliness.entity.Index;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.math.BigDecimal;
import java.security.Provider;

public class CalculateProfitability implements Command<Index, BigDecimal> {
    @Override
    public BigDecimal execute(Index request) {
        return ServiceFactory.getInstance().getBusinessService().calculateProfitability(request);
    }
}
