package com.loneliness.server.controller.command_implements.roe;

import com.loneliness.entity.Quarter;
import com.loneliness.entity.ROE;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class FindRoeByReportingPeriodYear implements Command<ReportingPeriod, Map<Quarter,ROE> > {
    @Override
    public Map<Quarter,ROE> execute(ReportingPeriod request) {
        return ServiceFactory.getInstance().getRoeService().findRoeByReportingPeriodYear(request);
    }
}
