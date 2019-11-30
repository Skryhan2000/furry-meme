package com.loneliness.server.controller.command_implements.credit;

import com.loneliness.entity.ContactDetail;
import com.loneliness.entity.Credit;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class ReceiveCredit implements Command<Credit,Credit> {
    @Override
    public Credit execute(Credit request) {
        return ServiceFactory.getInstance().getCreditService().receive(request);
    }
}
