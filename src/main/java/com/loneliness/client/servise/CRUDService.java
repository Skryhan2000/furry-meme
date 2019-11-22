package com.loneliness.client.servise;

public interface CRUDService <D, S, C> {
    S create(D obj) throws  ServiceException;
    D receive(D obj) throws  ServiceException;
    S update(D obj) throws  ServiceException;
    S delete(D obj) throws  ServiceException;
    C receiveAllElem() throws  ServiceException;
    C receiveAllElemInLimit(int left,int right) throws  ServiceException;
}
