package com.loneliness.client.controller.command_impl.report;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Report;
import com.loneliness.server.servise.ServiceFactory;
import net.sf.jasperreports.web.commands.CommandException;

public class CreateReport implements Command<Report,String> {
    @Override
    public String execute(Report request) throws ControllerException {
        try {
            return FactoryService.getInstance().getReportService().create(request);
        } catch (ServiceException e) {
            throw new ControllerException(e.getCause(),e.getMessage());
        }
    }
}
