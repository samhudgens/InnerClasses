package com.samhudgens;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by samhudgens on 5/20/16.
 */
public class ConnectionManagerSpec {

    ConnectionManager connectionManager;

    @Before
    public void initialize() {
        connectionManager = new ConnectionManager(4);
        connectionManager.makeAConnection("555666", Protocol.FTP);
        connectionManager.makeAConnection("78.9938.34", "55");
    }

    @Test
    public void numberOfConnectionsTest() {
        int expected = 2;
        int actual = connectionManager.getNumberOfConnections();
        assertEquals("should return 2", expected, actual);
    }

    @Test
    public void getConnectionsLimitTest() {
        int expected = 4;
        int actual = connectionManager.getConnectionsLimit();
        assertEquals("should return 4", expected, actual);
    }

    @Test
    public void preventNewConnectionsTest() {
        connectionManager.setNumberOfConnections(4);
        assertNull(connectionManager.makeAConnection("777.88", Protocol.HTTP));
    }

    @Test
    public void makeANewConnectionTest() {
        connectionManager.makeAConnection("777.88", Protocol.FTP);
        assertNotNull(connectionManager.makeAConnection("777.88", Protocol.FTP));
    }

    @Test
    public void closeAConnectionTest() {
        Connection test = connectionManager.makeAConnection("66739", "88");
        test.close();
        assertNull(test.getIp());
    }

}
