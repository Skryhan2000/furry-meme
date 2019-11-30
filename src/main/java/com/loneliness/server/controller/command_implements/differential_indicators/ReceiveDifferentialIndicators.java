package com.loneliness.server.controller.command_implements.differential_indicators;

import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class ReceiveDifferentialIndicators implements Command<DifferentialIndicators, DifferentialIndicators> {
    @Override
    public DifferentialIndicators execute(DifferentialIndicators request) {
        return ServiceFactory.getInstance().getDifferentialIndicatorsDataService().receive(request);
    }
}
