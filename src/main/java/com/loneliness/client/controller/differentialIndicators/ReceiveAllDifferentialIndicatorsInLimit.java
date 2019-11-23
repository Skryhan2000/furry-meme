package com.loneliness.client.controller.differentialIndicators;

import com.loneliness.client.controller.Command;
import com.loneliness.client.service.FactoryService;
import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.UserData;

import java.util.Map;

public class ReceiveAllDifferentialIndicatorsInLimit implements Command<int[], Map<Integer, DifferentialIndicators>> {
    @Override
    public Map<Integer, DifferentialIndicators> execute(int[] request) {
        return FactoryService.getInstance().getDifferentialIndicatorsService().receiveAllElemInLimit(request[0],request[1]);
    }
}
