package com.loneliness.client.controller.command_impl.roe;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.ROE;

public class FindRoeByReportingPeriodId implements Command<Integer,ROE> {
    @Override
    public ROE execute(Integer request) throws ControllerException {
        try {
            return FactoryService.getInstance().getRoeService().findRoeByReportingPeriodId(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
