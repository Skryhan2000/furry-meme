package com.loneliness.server.controller.command_implements.business;

import com.loneliness.entity.ROE;
import com.loneliness.server.controller.Command;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.servise.ServiceException;
import com.loneliness.server.servise.ServiceFactory;

public class CalculateAllROEData implements Command<ROE, ROE> {
    @Override
    public ROE execute(ROE request) throws ControllerException {
        try {
            return ServiceFactory.getInstance().getBusinessService().calculateAllROEData(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(), e.getMessage());
        }
    }
}
