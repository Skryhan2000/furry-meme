package com.loneliness.server.controller.command_implements.company;

import com.loneliness.entity.Company;
import com.loneliness.entity.UserData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllCompanyInLimit implements Command<int[], Map<Integer, Company>> {
    @Override
    public Map<Integer, Company> execute(int[] request) {
        return ServiceFactory.getInstance().getCompanyService().receiveAllInLimit(request[0],request[1]);
    }
}
