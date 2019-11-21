package com.loneliness.server.servise;

public interface Service <A,R,C>{
    R add(A note);
    R update(A note);
    A receive(A note);
    R delete(A note);
    C receiveAll();
    C receiveAllInLimit(int left,int right);
}
