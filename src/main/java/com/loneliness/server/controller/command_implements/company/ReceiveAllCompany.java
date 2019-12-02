package com.loneliness.server.controller.command_implements.company;

import com.loneliness.entity.Company;
import com.loneliness.entity.Transmission;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllCompany implements Command<Transmission, Map<Integer, Company>> {
    @Override
    public Map<Integer, Company> execute(Transmission request) {
        return ServiceFactory.getInstance().getCompanyService().receiveAll();
    }
}
