package com.loneliness.server.controller.command_implements.company;

import com.loneliness.entity.Company;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllCompany implements Command<Void, Map<Integer, Company>> {
    @Override
    public Map<Integer, Company> execute(Void request) {
        return ServiceFactory.getInstance().getCompanyService().receiveAll();
    }
}
