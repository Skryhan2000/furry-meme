package com.loneliness.server.controller.command_implements.company_representative;

import com.loneliness.entity.CompanyRepresentatives;
import com.loneliness.server.controller.Command;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.servise.ServiceException;
import com.loneliness.server.servise.ServiceFactory;

public class UpdateCompanyRepresentatives implements Command<CompanyRepresentatives,String> {
    @Override
    public String execute(CompanyRepresentatives request) throws ControllerException {
        try {
            return ServiceFactory.getInstance().getCompanyRepresentativeService().update(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
