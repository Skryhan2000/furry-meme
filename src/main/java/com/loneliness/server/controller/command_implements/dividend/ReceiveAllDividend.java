package com.loneliness.server.controller.command_implements.dividend;

import com.loneliness.entity.Dividend;
import com.loneliness.entity.Transmission;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllDividend implements Command<Transmission, Map<Integer, Dividend>> {
    @Override
    public Map<Integer, Dividend> execute(Transmission request) {
        return ServiceFactory.getInstance().getDividendService().receiveAll();
    }
}
