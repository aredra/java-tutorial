package design.facade;

public class Ftp {
    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect() {
        System.out.println(host + port);
    }

    public void moveDirectory() {
        System.out.println(path);
    }

    public void disConnect() {
        System.out.println("Disconnect");
    }

}
