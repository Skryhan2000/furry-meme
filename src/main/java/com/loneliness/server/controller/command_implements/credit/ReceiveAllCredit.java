package com.loneliness.server.controller.command_implements.credit;

import com.loneliness.entity.Credit;
import com.loneliness.entity.Transmission;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllCredit implements Command<Transmission, Map<Integer, Credit>> {
    @Override
    public Map<Integer, Credit> execute(Transmission request) {
        return ServiceFactory.getInstance().getCreditService().receiveAll();
    }
}
