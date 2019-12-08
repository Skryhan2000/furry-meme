package com.loneliness.client.controller.command_impl.company_representative;


import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.CompanyRepresentatives;
import com.loneliness.entity.Transmission;

import java.util.Map;

public class ReceiveAllCompanyRepresentatives implements Command<Transmission, Map<Integer, CompanyRepresentatives>> {
    @Override
    public Map<Integer, CompanyRepresentatives> execute(Transmission request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCompanyRepresentativeService().receiveAllElem();
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
