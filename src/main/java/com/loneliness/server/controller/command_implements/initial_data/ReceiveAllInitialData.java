package com.loneliness.server.controller.command_implements.initial_data;

import com.loneliness.entity.InitialData;
import com.loneliness.entity.Transmission;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllInitialData implements Command<Transmission, Map<Integer, InitialData>> {
    @Override
    public Map<Integer, InitialData> execute(Transmission request) {
        return ServiceFactory.getInstance().getInitialDataService().receiveAll();
    }
}
