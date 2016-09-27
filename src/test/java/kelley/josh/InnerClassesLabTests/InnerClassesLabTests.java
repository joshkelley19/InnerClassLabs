package kelley.josh.InnerClassesLabTests;

import kelley.josh.InnerClassesLab.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshuakelley on 9/27/16.
 */
public class InnerClassesLabTests {
    ConnectionManager connectionManager;
    ConnectionManager.ManagedConnection managedConnection;
    @Before
    public void initialize(){
        connectionManager = new ConnectionManager();
    }

    @Test
    public void createHTTPConnectionTest(){
        managedConnection= connectionManager.getHTTPConnection("1001100");
        String expected="Address 1001100 is now connected at 71 with a HTTP protocol";
        String actual=managedConnection.connect();
        assertEquals(expected,actual);
    }

    @Test
    public void createFTPConnectionTest(){
        managedConnection= connectionManager.getFTPConnection("1001100");
        String expected="Address 1001100 is now connected at 21 with a FTP protocol";
        String actual=managedConnection.connect();
        assertEquals(expected,actual);
    }

    @Test
    public void createSSHConnectionTest(){
        managedConnection= connectionManager.getSSHConnection("1001100");
        String expected="Address 1001100 is now connected at 22 with a SSH protocol";
        String actual=managedConnection.connect();
        assertEquals(expected,actual);
    }

    @Test
    public void createCustomConnectionTest(){
        managedConnection= connectionManager.getCustomConfiguredConnection("1001100",1234);
        String expected="Address 1001100 is now connected at 1234 with a HTTP protocol";
        String actual=managedConnection.connect();
        assertEquals(expected,actual);
    }

    @Test
    public void closeConnectionTest(){
        managedConnection= connectionManager.getFTPConnection("1001100");
        managedConnection.close();
        String expected="Error...closed connection";
        String actual=managedConnection.getIP();
        assertEquals(expected,actual);
    }

    @Test
    public void connectionLimitTest(){
        ConnectionManager.ManagedConnection managedConnection1= connectionManager.getFTPConnection("1001100");
        ConnectionManager.ManagedConnection managedConnection2= connectionManager.getFTPConnection("1001100");
        ConnectionManager.ManagedConnection managedConnection3= connectionManager.getFTPConnection("1001100");
        ConnectionManager.ManagedConnection managedConnection4= connectionManager.getFTPConnection("1001100");
        ConnectionManager.ManagedConnection managedConnection5= connectionManager.getFTPConnection("1001100");
        ConnectionManager.ManagedConnection expected=null;
        ConnectionManager.ManagedConnection actual=connectionManager.getFTPConnection("10010010101");
        assertEquals(expected,actual);
    }
}
