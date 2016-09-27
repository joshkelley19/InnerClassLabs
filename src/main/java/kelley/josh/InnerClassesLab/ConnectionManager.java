package kelley.josh.InnerClassesLab;

/**
 * Created by joshuakelley on 9/27/16.
 */
public class ConnectionManager {

    public int connections=0;

    public ManagedConnection getSSHConnection(String ip){
        if(connections>=5)return null;
        connections++;
        return new ManagedConnection(ip,22,"SSH");
    }
    public ManagedConnection getFTPConnection(String ip){
        if(connections>=5)return null;
        connections++;
        return new ManagedConnection(ip,21,"FTP");
    }
    public ManagedConnection getHTTPConnection(String ip){
        if(connections>=5)return null;
        connections++;
        return new ManagedConnection(ip,71,"HTTP");
    }
    public ManagedConnection getCustomConfiguredConnection(String ip,int port){
        if(connections>=5)return null;
        connections++;
        return new ManagedConnection(ip,port,"HTTP");
    }


    public class ManagedConnection implements Connection{
        private String ip;
        private int port;
        private String protocol;
        private boolean closed=false;

        public ManagedConnection(String ip,int port,String protocol){
            this.ip=ip;this.port=port;this.protocol=protocol;
            System.out.println(connect());
        }

        @Override
        public String connect() {
            String connectMessage="Address "+ip+" is now connected at "+port+" with a "+protocol+" protocol";
            return connectMessage;
        }

        @Override
        public void setIP(String ip) {
            if(closed){
                System.out.println("Error...closed connection");
                return;
            }
            this.ip=ip;

        }

        @Override
        public void setPort(int port) {
            if(closed){
                System.out.println("Error...closed connection");
                return;
            }
            this.port=port;
        }

        @Override
        public void setProtocol(String protocol) {
            if(closed){
                System.out.println("Error...closed connection");
                return;
            }
            this.protocol=protocol;
        }

        @Override
        public String getIP() {
            if(closed){
                return "Error...closed connection";
            }
            return ip;
        }

        @Override
        public int getPort() {
            if(closed){
                System.out.println("Error...closed connection");
                return 0;
            }
            return port;
        }

        @Override
        public String getProtocol() {
            if(closed){
                return "Error...closed connection";
            }
            return protocol;
        }

        @Override
        public void close() {
            closed=true;
            connections--;
        }

    }
}
