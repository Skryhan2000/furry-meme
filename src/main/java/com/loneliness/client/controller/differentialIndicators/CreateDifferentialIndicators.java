package com.loneliness.client.controller.differentialIndicators;

import com.loneliness.client.controller.Command;
import com.loneliness.client.service.FactoryService;
import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.UserData;


public class CreateDifferentialIndicators implements Command<DifferentialIndicators,String> {
    @Override
    public String execute(DifferentialIndicators request) {
        return FactoryService.getInstance().getDifferentialIndicatorsService().create(request);
    }
}
