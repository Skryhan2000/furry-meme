package com.loneliness.server.controller.command_implements.reporting_period;

import com.loneliness.entity.InitialData;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllReportingPeriod implements Command<Void, Map<Integer, ReportingPeriod>> {
    @Override
    public Map<Integer, ReportingPeriod> execute(Void request) {
        return ServiceFactory.getInstance().getReportingPeriodService().receiveAll();
    }
}
