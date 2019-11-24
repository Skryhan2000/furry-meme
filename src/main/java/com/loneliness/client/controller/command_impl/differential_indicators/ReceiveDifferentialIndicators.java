package com.loneliness.client.controller.command_impl.differential_indicators;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.DifferentialIndicators;

public class ReceiveDifferentialIndicators implements Command<DifferentialIndicators,DifferentialIndicators> {
    @Override
    public DifferentialIndicators execute(DifferentialIndicators request) throws ControllerException {
        try {
            return FactoryService.getInstance().getDifferentialIndicatorsService().receive(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
