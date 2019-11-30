package com.loneliness.client.controller.command_impl.calculate;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Index;

import java.math.BigDecimal;

public class CalculateNetAssetTurnover implements Command<Index, BigDecimal> {
    @Override
    public BigDecimal execute(Index request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCalculateIndexRequest().calculateNetAssetTurnover(request);
        } catch ( ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
