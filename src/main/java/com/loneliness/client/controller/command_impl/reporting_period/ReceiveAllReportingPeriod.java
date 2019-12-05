package com.loneliness.client.controller.command_impl.reporting_period;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.ReportingPeriod;

import java.util.Map;

public class ReceiveAllReportingPeriod implements Command<Object, Map<Integer, ReportingPeriod>> {
    @Override
    public Map<Integer, ReportingPeriod> execute(Object request) throws ControllerException {
        try {
            return FactoryService.getInstance().getReportingPeriodService().receiveAllElem();
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
