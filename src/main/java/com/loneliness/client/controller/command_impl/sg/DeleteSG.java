package com.loneliness.client.controller.command_impl.sg;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.SG;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class DeleteSG implements Command<SG,String> {
    @Override
    public String execute(SG request) throws ControllerException {
        try {
            return FactoryService.getInstance().getSgService().delete(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
