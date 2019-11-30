package com.loneliness.server.controller.command_implements.roe;

import com.loneliness.entity.ROE;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class ReceiveROE implements Command<ROE, ROE> {
    @Override
    public ROE execute(ROE request) {
        return ServiceFactory.getInstance().getRoeService().receive(request);
    }
}
