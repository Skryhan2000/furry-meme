package com.loneliness.client.controller.command_impl.credit;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Credit;

import java.util.Map;

public class ReceiveAllCredit implements Command<Object, Map<Integer, Credit>> {
    @Override
    public Map<Integer, Credit> execute(Object request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCreditService().receiveAllElem();
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
