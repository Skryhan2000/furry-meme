package com.loneliness.server.controller.command_implements.initial_data;

import com.loneliness.entity.Dividend;
import com.loneliness.entity.InitialData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllInitialDataInLimit implements Command<int[], Map<Integer, InitialData>> {
    @Override
    public Map<Integer, InitialData> execute(int[] request) {
        return ServiceFactory.getInstance().getInitialDataService().receiveAllInLimit(request[0],request[1]);
    }
}
