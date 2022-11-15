package design.facade;

public class Writer {

    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String msg = String.format("Writer %s fileConnect..", fileName);
        System.out.println(msg);
    }

    public void fileWriter() {
        String msg = String.format("Writer %s fileWrite..", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect() {
        String msg = String.format("Writer %s fileDisconnect..", fileName);
        System.out.println(msg);
    }
}
