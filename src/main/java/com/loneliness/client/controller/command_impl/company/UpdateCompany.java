package com.loneliness.client.controller.command_impl.company;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Company;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class UpdateCompany implements Command<Company,String> {
    @Override
    public String execute(Company request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCompanyService().update(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
