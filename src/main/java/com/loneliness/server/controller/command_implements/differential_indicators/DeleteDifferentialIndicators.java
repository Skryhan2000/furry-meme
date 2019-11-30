package com.loneliness.server.controller.command_implements.differential_indicators;

import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class DeleteDifferentialIndicators implements Command<DifferentialIndicators,String> {
    @Override
    public String execute(DifferentialIndicators request) {
        return ServiceFactory.getInstance().getDifferentialIndicatorsDataService().delete(request);
    }
}
