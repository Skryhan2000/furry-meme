package com.loneliness.server.controller.command_implements.roe;

import com.loneliness.entity.ROE;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.controller.Command;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.servise.ServiceException;
import com.loneliness.server.servise.ServiceFactory;

public class UpdateROE implements Command<ROE,String> {
    @Override
    public String execute(ROE request) throws ControllerException {
        try {
            return ServiceFactory.getInstance().getRoeService().update(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
