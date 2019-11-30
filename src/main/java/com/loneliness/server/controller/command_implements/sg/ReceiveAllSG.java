package com.loneliness.server.controller.command_implements.sg;

import com.loneliness.entity.ReportingPeriod;
import com.loneliness.entity.SG;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllSG implements Command<Void, Map<Integer, SG>> {
    @Override
    public Map<Integer, SG> execute(Void request) {
        return ServiceFactory.getInstance().getSgService().receiveAll();
    }
}
