package com.loneliness.server.controller.command_implements.contact_detail;

import com.loneliness.entity.Company;
import com.loneliness.entity.ContactDetail;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllContactDetailInLimit implements Command<int[], Map<Integer, ContactDetail>> {
    @Override
    public Map<Integer, ContactDetail> execute(int[] request) {
        return ServiceFactory.getInstance().getContactDetailService().receiveAllInLimit(request[0],request[1]);
    }
}
