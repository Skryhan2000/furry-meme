package com.loneliness.server.controller.command_implements.reporting_period;

import com.loneliness.entity.InitialData;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class ReceiveReportingPeriod implements Command<ReportingPeriod,ReportingPeriod> {
    @Override
    public ReportingPeriod execute(ReportingPeriod request) {
        return ServiceFactory.getInstance().getReportingPeriodService().receive(request);
    }
}
