package com.loneliness.server.controller.command_implements.company_representative;

import com.loneliness.entity.CompanyRepresentatives;
import com.loneliness.entity.Transmission;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllCompanyRepresentatives implements Command<Transmission, Map<Integer, CompanyRepresentatives>> {
    @Override
    public Map<Integer, CompanyRepresentatives> execute(Transmission request) {
        return ServiceFactory.getInstance().getCompanyRepresentativeService().receiveAll();
    }
}
