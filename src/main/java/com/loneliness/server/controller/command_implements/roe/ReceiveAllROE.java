package com.loneliness.server.controller.command_implements.roe;

import com.loneliness.entity.ROE;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllROE implements Command<Void, Map<Integer, ROE>> {
    @Override
    public Map<Integer, ROE> execute(Void request) {
        return ServiceFactory.getInstance().getRoeService().receiveAll();
    }
}
