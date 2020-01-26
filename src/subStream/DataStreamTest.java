package subStream;

import java.io.*;

public class DataStreamTest {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("output.txt");
             DataOutputStream dos = new DataOutputStream(fos);
             FileInputStream fis = new FileInputStream("output.txt");
             DataInputStream dis = new DataInputStream(fis)) {

            dos.writeByte(100);
            dos.writeChar('A');
            dos.writeUTF("안녕하세요");

            System.out.println(dis.readByte());
            System.out.println(dis.readChar());
            System.out.println(dis.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
