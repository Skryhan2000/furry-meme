package com.loneliness.client.controller.command_impl.sg;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.SG;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllSGInLimit implements Command<int[], Map<Integer, SG>> {
    @Override
    public Map<Integer, SG> execute(int[] request) throws ControllerException {
        try {
            return FactoryService.getInstance().getSgService().receiveAllElemInLimit(request[0],request[1]);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
