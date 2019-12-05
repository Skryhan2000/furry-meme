package com.loneliness.client.controller.command_impl.roe;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Quarter;
import com.loneliness.entity.ROE;
import com.loneliness.entity.ReportingPeriod;

import java.util.Map;

public class FindRoeByReportingPeriodYear implements Command<ReportingPeriod, Map<Quarter, ROE>> {
    @Override
    public Map<Quarter, ROE> execute(ReportingPeriod request) throws ControllerException {
        try {
            return FactoryService.getInstance().getRoeService().findRoeByReportingPeriodYear(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
