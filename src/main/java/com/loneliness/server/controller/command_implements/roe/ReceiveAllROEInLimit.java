package com.loneliness.server.controller.command_implements.roe;

import com.loneliness.entity.ROE;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllROEInLimit implements Command<int[], Map<Integer, ROE>> {
    @Override
    public Map<Integer, ROE> execute(int[] request) {
        return ServiceFactory.getInstance().getRoeService().receiveAllInLimit(request[0],request[1]);
    }
}
