package com.loneliness.server.controller.command_implements.reporting_period;

import com.loneliness.entity.ReportingPeriod;
import com.loneliness.entity.Transmission;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllReportingPeriod implements Command<Transmission, Map<Integer, ReportingPeriod>> {
    @Override
    public Map<Integer, ReportingPeriod> execute(Transmission request) {
        return ServiceFactory.getInstance().getReportingPeriodService().receiveAll();
    }
}
