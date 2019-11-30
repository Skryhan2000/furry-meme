package com.loneliness.server.controller.command_implements.credit;

import com.loneliness.entity.ContactDetail;
import com.loneliness.entity.Credit;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllCreditInLimit implements Command<int[], Map<Integer, Credit>> {
    @Override
    public Map<Integer, Credit> execute(int[] request) {
        return ServiceFactory.getInstance().getCreditService().receiveAllInLimit(request[0],request[1]);
    }
}
