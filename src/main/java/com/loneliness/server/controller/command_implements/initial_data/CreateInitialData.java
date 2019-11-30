package com.loneliness.server.controller.command_implements.initial_data;

import com.loneliness.entity.Dividend;
import com.loneliness.entity.InitialData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class CreateInitialData implements Command <InitialData,String>{
    @Override
    public String execute(InitialData request) {
        return ServiceFactory.getInstance().getInitialDataService().add(request);
    }
}
