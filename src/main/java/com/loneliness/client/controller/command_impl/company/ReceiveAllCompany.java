package com.loneliness.client.controller.command_impl.company;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Company;

import java.util.Map;

public class ReceiveAllCompany implements Command<Object, Map<Integer, Company>> {
    @Override
    public Map<Integer, Company> execute(Object request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCompanyService().receiveAllElem();
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
