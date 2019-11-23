package com.loneliness.client.controller.command_impl.differential_indicators;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.DifferentialIndicators;

import java.util.Map;

public class ReceiveAllDifferentialIndicators implements Command<Void, Map<Integer, DifferentialIndicators>> {
    @Override
    public Map<Integer, DifferentialIndicators> execute(Void request) throws ControllerException {
        try {
            return FactoryService.getInstance().getDifferentialIndicatorsService().receiveAllElem();
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
