package com.loneliness.server.controller.command_implements.contact_detail;

import com.loneliness.entity.ContactDetail;
import com.loneliness.entity.UserData;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class ReceiveContactDetail implements Command<ContactDetail,ContactDetail> {
    @Override
    public ContactDetail execute(ContactDetail request) {
        return ServiceFactory.getInstance().getContactDetailService().receive(request);
    }
}
