package com.loneliness.client.controller.command_impl.company;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Company;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllCompanyInLimit implements Command<int[], Map<Integer, Company>> {
    @Override
    public Map<Integer, Company> execute(int[] request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCompanyService().receiveAllElemInLimit(request[0],request[1]);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());

        }
    }
}
