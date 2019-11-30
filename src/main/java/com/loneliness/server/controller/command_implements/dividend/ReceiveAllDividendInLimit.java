package com.loneliness.server.controller.command_implements.dividend;

import com.loneliness.entity.Credit;
import com.loneliness.entity.Dividend;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllDividendInLimit implements Command<int[], Map<Integer, Dividend>> {
    @Override
    public Map<Integer, Dividend> execute(int[] request) {
        return ServiceFactory.getInstance().getDividendService().receiveAllInLimit(request[0],request[1]);
    }
}
