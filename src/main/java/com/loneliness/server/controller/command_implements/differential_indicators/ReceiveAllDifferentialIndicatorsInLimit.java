package com.loneliness.server.controller.command_implements.differential_indicators;

import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllDifferentialIndicatorsInLimit implements Command<int[], Map<Integer, DifferentialIndicators>> {
    @Override
    public Map<Integer, DifferentialIndicators> execute(int[] request) {
        return ServiceFactory.getInstance().getDifferentialIndicatorsDataService().receiveAllInLimit(request[0],request[1]);
    }
}
