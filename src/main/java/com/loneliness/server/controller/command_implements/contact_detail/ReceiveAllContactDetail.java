package com.loneliness.server.controller.command_implements.contact_detail;

import com.loneliness.entity.Company;
import com.loneliness.entity.ContactDetail;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllContactDetail implements Command<Void, Map<Integer, ContactDetail>> {
    @Override
    public Map<Integer, ContactDetail> execute(Void request) {
        return ServiceFactory.getInstance().getContactDetailService().receiveAll();
    }
}
