package design.facade;

public class Reader {

    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String msg = String.format("Reader %s fileConnect..", fileName);
        System.out.println(msg);
    }

    public void fileRead() {
        String msg = String.format("Reader %s fileRead..", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect() {
        String msg = String.format("Reader %s fileDisconnect..", fileName);
        System.out.println(msg);
    }
}
