package com.loneliness.client.controller.user_command;

import com.loneliness.client.controller.Command;
import com.loneliness.client.servise.FactoryService;
import com.loneliness.entity.UserData;



import java.util.Map;

public class ReceiveAllUsers implements Command<Void, Map<Integer, UserData>> {
    @Override
    public Map<Integer, UserData> execute(Void request) {
        return FactoryService.getInstance().getUserService().receiveAllElem();
    }
}
