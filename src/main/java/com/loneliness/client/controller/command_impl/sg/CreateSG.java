package com.loneliness.client.controller.command_impl.sg;


import com.loneliness.client.service.FactoryService;
import com.loneliness.entity.SG;
import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;


public class CreateSG implements Command <SG,String>{
    @Override
    public String execute(SG request) throws ControllerException {
        try {
            return FactoryService.getInstance().getSgService().create(request);
        } catch (com.loneliness.client.service.ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
