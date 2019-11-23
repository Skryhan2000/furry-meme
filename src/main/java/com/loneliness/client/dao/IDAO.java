package com.loneliness.client.dao;

public interface IDAO<A,R,C>{
    R add(A note) throws DAOException;
    R update(A note) throws DAOException;
    A receive(A note) throws DAOException;
    R delete(A note) throws DAOException;
    C receiveAll() throws DAOException;
    C receiveAllInLimit(int left,int right) throws DAOException;
}