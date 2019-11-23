package com.loneliness.client.controller.command_impl.user;

import com.loneliness.client.controller.Command;
import com.loneliness.client.service.FactoryService;
import com.loneliness.entity.UserData;



import java.util.Map;

public class ReceiveAllUsers implements Command<Void, Map<Integer, UserData>> {
    @Override
    public Map<Integer, UserData> execute(Void request) {
        return FactoryService.getInstance().getUserService().receiveAllElem();
    }
}
