package com.samhudgens;

/**
 * Created by samhudgens on 5/20/16.
 */
public class ConnectionManager {

    int numberOfConnections = 0;
    int connectionsLimit;

    public Connection makeAConnection(String ip, Protocol protocol) {
        if(numberOfConnections < connectionsLimit) {
            return new ManagedConnection(ip, protocol);
        } else {
            System.out.println("Cannot make another connection -- too many connections already");
            return null;
        }
    }

    public Connection makeAConnection(String ip, String port) {
        if(numberOfConnections < connectionsLimit) {
            return new ManagedConnection(ip, port);
        } else {
            System.out.println("Cannot make another connection -- too many connections already");
            return null;
        }
    }

    /// Constructor
    ConnectionManager(int connectionsLimit) {
        this.connectionsLimit = connectionsLimit;
    }




    public int getNumberOfConnections() {
        return this.numberOfConnections;
    }

    public int getConnectionsLimit() {
        return this.connectionsLimit;
    }

    public void setConnectionsLimit(int newLimit) {
        this.connectionsLimit = newLimit;
    }

    public void setNumberOfConnections(int numberOfConnections) {
        this.numberOfConnections = numberOfConnections;
    }





    private class ManagedConnection implements Connection {

        private String ip;
        private String port;
        private Protocol protocol;

        public ManagedConnection(String ip, Protocol protocol) {
            this.ip = ip;
            this.protocol = protocol;
            numberOfConnections++;
        }

        public ManagedConnection(String ip, String port) {
            this.ip = ip;
            this.port = port;
            this.protocol = Protocol.HTTP;
            numberOfConnections++;
        }

        public String getIp() {
            return this.ip;
        }

        public String getPort() {
            return this.port;
        }

        public Protocol getProtocol() {
            return this.protocol;
        }

        public String connect() {
            return null;
        }

        public void close() {
            this.ip = null;
            this.port = null;
            this.protocol = null;
            numberOfConnections--;
        }

    }

}
