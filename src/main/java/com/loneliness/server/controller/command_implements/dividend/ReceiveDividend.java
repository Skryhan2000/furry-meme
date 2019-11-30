package com.loneliness.server.controller.command_implements.dividend;

import com.loneliness.entity.Credit;
import com.loneliness.entity.Dividend;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class ReceiveDividend implements Command<Dividend,Dividend> {
    @Override
    public Dividend execute(Dividend request) {
        return ServiceFactory.getInstance().getDividendService().receive(request);
    }
}
