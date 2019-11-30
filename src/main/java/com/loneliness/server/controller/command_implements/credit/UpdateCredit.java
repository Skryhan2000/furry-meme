package com.loneliness.server.controller.command_implements.credit;

import com.loneliness.entity.ContactDetail;
import com.loneliness.entity.Credit;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class UpdateCredit implements Command<Credit,String> {
    @Override
    public String execute(Credit request) {
        return ServiceFactory.getInstance().getCreditService().update(request);
    }
}
