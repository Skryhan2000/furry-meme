package com.loneliness.server.controller.command_implements.sg;

import com.loneliness.entity.SG;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class FindSGByReportingPeriodID implements Command<Integer,SG> {
    @Override
    public SG execute(Integer request) {
        return ServiceFactory.getInstance().getSgService().findSGByReportingPeriodID(request);
    }
}
