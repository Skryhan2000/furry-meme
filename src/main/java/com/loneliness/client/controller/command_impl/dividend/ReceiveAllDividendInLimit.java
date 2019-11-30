package com.loneliness.client.controller.command_impl.dividend;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Dividend;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllDividendInLimit implements Command<int[], Map<Integer, Dividend>> {
    @Override
    public Map<Integer, Dividend> execute(int[] request) throws ControllerException {
        try {
            return FactoryService.getInstance().getDividendService().receiveAllElemInLimit(request[0],request[1]);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
