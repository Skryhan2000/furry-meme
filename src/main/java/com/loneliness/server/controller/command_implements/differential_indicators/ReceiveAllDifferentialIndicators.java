package com.loneliness.server.controller.command_implements.differential_indicators;

import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllDifferentialIndicators implements Command<Void, Map<Integer, DifferentialIndicators>> {
    @Override
    public Map<Integer, DifferentialIndicators> execute(Void request) {
        return ServiceFactory.getInstance().getDifferentialIndicatorsDataService().receiveAll();
    }
}
