package com.loneliness.server.controller.command_implements.credit;

import com.loneliness.entity.Credit;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.math.BigDecimal;

public class FindCreditInPeriod implements Command<Integer,BigDecimal> {
    @Override
    public BigDecimal execute(Integer request) {
        return ServiceFactory.getInstance().getReportingPeriodService().findCreditInPeriod(request);
    }
}

