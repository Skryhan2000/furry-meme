package com.loneliness.client.controller.command_impl.contact_detail;

import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.ContactDetail;
import com.loneliness.client.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

public class DeleteContactDetail implements Command<ContactDetail,String> {
    @Override
    public String execute(ContactDetail request) throws ControllerException {
        try {
            return FactoryService.getInstance().getContactDetailService().delete(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
