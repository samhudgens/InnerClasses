package com.samhudgens;

/**
 * Created by samhudgens on 5/20/16.
 */
public interface Connection {

    String getIp();
    String getPort();
    Protocol getProtocol();
    String connect();
    void close();
}
