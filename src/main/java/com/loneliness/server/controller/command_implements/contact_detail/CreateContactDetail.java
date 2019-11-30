package com.loneliness.server.controller.command_implements.contact_detail;

import com.loneliness.entity.Company;
import com.loneliness.entity.ContactDetail;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class CreateContactDetail implements Command <ContactDetail,String>{
    @Override
    public String execute(ContactDetail request) {
        return ServiceFactory.getInstance().getContactDetailService().add(request);
    }
}
