package kelley.josh.InnerClassesLab;

/**
 * Created by joshuakelley on 9/27/16.
 */
public interface Connection {

    String connect();
    void setIP(String ip);
    void setPort(int port);
    void setProtocol(String protocol);
    String getIP();
    int getPort();
    String getProtocol();
    void close();
}
