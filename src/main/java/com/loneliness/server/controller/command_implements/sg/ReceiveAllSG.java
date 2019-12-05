package com.loneliness.server.controller.command_implements.sg;

import com.loneliness.entity.SG;
import com.loneliness.entity.Transmission;
import com.loneliness.server.controller.Command;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ReceiveAllSG implements Command<Transmission, Map<Integer, SG>> {
    @Override
    public Map<Integer, SG> execute(Transmission request) {
        return ServiceFactory.getInstance().getSgService().receiveAll();
    }
}
