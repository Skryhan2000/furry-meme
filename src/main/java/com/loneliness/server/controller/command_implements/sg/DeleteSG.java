package com.loneliness.server.controller.command_implements.sg;

import com.loneliness.entity.ReportingPeriod;
import com.loneliness.entity.SG;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class DeleteSG implements Command<SG,String> {
    @Override
    public String execute(SG request) {
        return ServiceFactory.getInstance().getSgService().delete(request);
    }
}
