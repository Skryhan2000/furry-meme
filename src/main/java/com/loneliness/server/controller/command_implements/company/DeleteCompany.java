package com.loneliness.server.controller.command_implements.company;

import com.loneliness.entity.Company;
import com.loneliness.entity.UserData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class DeleteCompany implements Command<Company,String> {
    @Override
    public String execute(Company request) {
        return ServiceFactory.getInstance().getCompanyService().delete(request);
    }
}
