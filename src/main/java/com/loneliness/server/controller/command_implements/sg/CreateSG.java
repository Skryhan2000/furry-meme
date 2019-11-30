package com.loneliness.server.controller.command_implements.sg;


import com.loneliness.entity.SG;
import com.loneliness.server.controller.Command;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.servise.ServiceException;
import com.loneliness.server.servise.ServiceFactory;

public class CreateSG implements Command <SG,String>{
    @Override
    public String execute(SG request) throws ControllerException {
        try {
            return ServiceFactory.getInstance().getSgService().add(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
