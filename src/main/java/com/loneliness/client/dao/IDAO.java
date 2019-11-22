package com.loneliness.client.dao;

public interface IDAO<A,R,C>{
    R add(A note);
    R update(A note);
    A receive(A note);
    R delete(A note);
    C receiveAll();
    C receiveAllInLimit(int left,int right);
}