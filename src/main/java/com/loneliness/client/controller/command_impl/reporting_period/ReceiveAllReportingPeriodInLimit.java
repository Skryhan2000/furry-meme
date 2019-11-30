package com.loneliness.client.controller.command_impl.reporting_period;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllReportingPeriodInLimit implements Command<int[], Map<Integer, ReportingPeriod>> {
    @Override
    public Map<Integer, ReportingPeriod> execute(int[] request) throws ControllerException {
        try {
            return FactoryService.getInstance().getReportingPeriodService().receiveAllElemInLimit(request[0],request[1]);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
