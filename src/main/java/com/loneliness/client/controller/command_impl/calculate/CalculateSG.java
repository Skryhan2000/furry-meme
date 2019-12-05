package com.loneliness.client.controller.command_impl.calculate;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Index;
import com.loneliness.entity.SG;


import java.math.BigDecimal;

public class CalculateSG implements Command<SG, BigDecimal> {
    @Override
    public BigDecimal execute(SG request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCalculateIndexRequest().calculateSG(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
