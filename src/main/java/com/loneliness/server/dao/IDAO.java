package com.loneliness.server.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IDAO<A,R,C>{
    Logger logger = LogManager.getLogger();
    R add(A note);
    R update(A note);
    A receive(A note);
    R delete(A note);
    C receiveAll();
    C receiveAllInLimit(int left,int right);
}
