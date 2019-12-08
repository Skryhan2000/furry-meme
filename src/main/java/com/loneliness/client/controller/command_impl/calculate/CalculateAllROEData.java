package com.loneliness.client.controller.command_impl.calculate;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.ROE;


public class CalculateAllROEData implements Command<ROE, ROE> {
    @Override
    public ROE execute(ROE request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCalculateIndexRequest().CalculateAllROEData(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
