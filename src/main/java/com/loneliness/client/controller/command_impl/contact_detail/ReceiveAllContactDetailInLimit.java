package com.loneliness.client.controller.command_impl.contact_detail;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.ContactDetail;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllContactDetailInLimit implements Command<int[], Map<Integer, ContactDetail>> {
    @Override
    public Map<Integer, ContactDetail> execute(int[] request) throws ControllerException {
        try {
            return FactoryService.getInstance().getContactDetailService().receiveAllElemInLimit(request[0],request[1]);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
