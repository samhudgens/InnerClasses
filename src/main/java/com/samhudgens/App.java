package com.samhudgens;

/**
 * Created by samhudgens on 5/20/16.
 */
public class App {

    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager(5);

        Connection firstConnection = connectionManager.makeAConnection("555566", Protocol.HTTP);
    }
}
