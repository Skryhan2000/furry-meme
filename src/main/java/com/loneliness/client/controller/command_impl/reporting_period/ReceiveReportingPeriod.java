package com.loneliness.client.controller.command_impl.reporting_period;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class ReceiveReportingPeriod implements Command<ReportingPeriod,ReportingPeriod> {
    @Override
    public ReportingPeriod execute(ReportingPeriod request) throws ControllerException {
        try {
            return FactoryService.getInstance().getReportingPeriodService().receive(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
