package com.loneliness.client.controller.command_impl.calculate_Index;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.Index;

public class CalculateAllDifferentialIndicators implements Command<Index, DifferentialIndicators> {
    @Override
    public DifferentialIndicators execute(Index request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCalculateIndexRequest().calculateAllDifferentialIndicators(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
