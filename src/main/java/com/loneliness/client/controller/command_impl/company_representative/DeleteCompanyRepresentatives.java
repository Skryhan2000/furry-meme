package com.loneliness.client.controller.command_impl.company_representative;


import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.CompanyRepresentatives;

public class DeleteCompanyRepresentatives implements Command<CompanyRepresentatives,String> {
    @Override
    public String execute(CompanyRepresentatives request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCompanyRepresentativeService().delete(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
