package com.loneliness.server.controller.command_implements.initial_data;

import com.loneliness.entity.InitialData;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.math.BigDecimal;

public class FindFutureEquity implements Command<InitialData,BigDecimal> {
    @Override
    public BigDecimal execute(InitialData request) {
        return ServiceFactory.getInstance().getReportingPeriodService().findFutureEquity(request);
    }

}
