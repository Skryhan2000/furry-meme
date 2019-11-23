package com.loneliness.client.controller.command_impl.differential_indicators;

import com.loneliness.client.controller.Command;
import com.loneliness.client.service.FactoryService;
import com.loneliness.entity.DifferentialIndicators;

import java.util.Map;

public class ReceiveAllDifferentialIndicators implements Command<Void, Map<Integer, DifferentialIndicators>> {
    @Override
    public Map<Integer, DifferentialIndicators> execute(Void request) {
        return FactoryService.getInstance().getDifferentialIndicatorsService().receiveAllElem();
    }
}
