package com.loneliness.server.controller.command_implements.contact_detail;

import com.loneliness.entity.ContactDetail;
import com.loneliness.entity.Transmission;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllContactDetail implements Command<Transmission, Map<Integer, ContactDetail>> {
    @Override
    public Map<Integer, ContactDetail> execute(Transmission request) {
        return ServiceFactory.getInstance().getContactDetailService().receiveAll();
    }
}
