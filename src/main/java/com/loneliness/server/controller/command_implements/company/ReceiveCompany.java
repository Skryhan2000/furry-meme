package com.loneliness.server.controller.command_implements.company;

import com.loneliness.entity.Company;
import com.loneliness.entity.UserData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class ReceiveCompany implements Command<Company,Company> {
    @Override
    public Company execute(Company request) {
        return ServiceFactory.getInstance().getCompanyService().receive(request);
    }
}
