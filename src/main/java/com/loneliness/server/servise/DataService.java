package com.loneliness.server.servise;

public interface DataService<A,R,C>{
    R add(A note) throws ServiceException;
    R update(A note) throws ServiceException;
    A receive(A note);
    R delete(A note);
    C receiveAll();
    C receiveAllInLimit(int left,int right);
}
