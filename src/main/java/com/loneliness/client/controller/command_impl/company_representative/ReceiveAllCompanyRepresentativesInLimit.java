package com.loneliness.client.controller.command_impl.company_representative;


import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.CompanyRepresentatives;

import java.util.Map;

public class ReceiveAllCompanyRepresentativesInLimit implements Command<int[], Map<Integer, CompanyRepresentatives>> {
    @Override
    public Map<Integer, CompanyRepresentatives> execute(int[] request) throws ControllerException {
        try {
            return FactoryService.getInstance().getCompanyRepresentativeService().receiveAllElemInLimit(request[0],request[1]);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
