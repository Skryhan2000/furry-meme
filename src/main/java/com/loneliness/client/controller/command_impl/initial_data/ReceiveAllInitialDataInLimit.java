package com.loneliness.client.controller.command_impl.initial_data;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.InitialData;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllInitialDataInLimit implements Command<int[], Map<Integer, InitialData>> {
    @Override
    public Map<Integer, InitialData> execute(int[] request) throws ControllerException {
        try {
            return FactoryService.getInstance().getInitialDataService().receiveAllElemInLimit(request[0],request[1]);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
