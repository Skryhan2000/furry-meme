package com.loneliness.client.controller.command_impl.sg;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.SG;

public class FindSGByReportingPeriodID implements Command<Integer,SG> {
    @Override
    public SG execute(Integer request) throws ControllerException {
        try {
            return FactoryService.getInstance().getSgService().findSGByReportingPeriodID(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
