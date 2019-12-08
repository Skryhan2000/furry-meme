package com.loneliness.server.controller.command_implements.company_representative;

import com.loneliness.entity.CompanyRepresentatives;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllCompanyRepresentativesInLimit implements Command<int[], Map<Integer, CompanyRepresentatives>> {
    @Override
    public Map<Integer, CompanyRepresentatives> execute(int[] request) {
        return ServiceFactory.getInstance().getCompanyRepresentativeService().receiveAllInLimit(request[0],request[1]);
    }
}
