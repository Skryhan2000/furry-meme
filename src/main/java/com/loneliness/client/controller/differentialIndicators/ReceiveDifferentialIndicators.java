package com.loneliness.client.controller.differentialIndicators;

import com.loneliness.client.controller.Command;
import com.loneliness.client.service.FactoryService;
import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.UserData;

public class ReceiveDifferentialIndicators implements Command<DifferentialIndicators,DifferentialIndicators> {
    @Override
    public DifferentialIndicators execute(DifferentialIndicators request) {
        return FactoryService.getInstance().getDifferentialIndicatorsService().receive(request);
    }
}
