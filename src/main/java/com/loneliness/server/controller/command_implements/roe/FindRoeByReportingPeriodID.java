package com.loneliness.server.controller.command_implements.roe;

import com.loneliness.entity.ROE;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class FindRoeByReportingPeriodID implements Command<Integer, ROE> {
    @Override
    public ROE execute(Integer request) {
        return ServiceFactory.getInstance().getRoeService().findRoeByReportingPeriodID(request);
    }
}
