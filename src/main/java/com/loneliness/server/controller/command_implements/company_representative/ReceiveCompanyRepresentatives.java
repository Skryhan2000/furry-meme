package com.loneliness.server.controller.command_implements.company_representative;

import com.loneliness.entity.CompanyRepresentatives;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class ReceiveCompanyRepresentatives implements Command<CompanyRepresentatives,CompanyRepresentatives> {
    @Override
    public CompanyRepresentatives execute(CompanyRepresentatives request) {
        return ServiceFactory.getInstance().getCompanyRepresentativeService().receive(request);
    }
}
