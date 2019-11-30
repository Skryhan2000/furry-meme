package com.loneliness.server.controller.command_implements.roe;

import com.loneliness.entity.ROE;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class DeleteROE implements Command<ROE,String> {
    @Override
    public String execute(ROE request) {
        return ServiceFactory.getInstance().getRoeService().delete(request);
    }
}
