package com.loneliness.client.controller.command_impl.initial_data;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.InitialData;

import java.util.Map;

public class ReceiveAllInitialData implements Command<Object, Map<Integer, InitialData>> {
    @Override
    public Map<Integer, InitialData> execute(Object request) throws ControllerException {
        try {
            return FactoryService.getInstance().getInitialDataService().receiveAllElem();
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
