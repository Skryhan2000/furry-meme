package com.loneliness.server.controller.command_implements.company_representative;

import com.loneliness.entity.CompanyRepresentatives;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class DeleteCompanyRepresentatives implements Command<CompanyRepresentatives,String> {
    @Override
    public String execute(CompanyRepresentatives request) {
        return ServiceFactory.getInstance().getCompanyRepresentativeService().delete(request);
    }
}
