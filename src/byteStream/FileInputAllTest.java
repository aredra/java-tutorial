package byteStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputAllTest {
    public static void main(String[] args) {

        System.out.println("start");

        try (FileInputStream fis = new FileInputStream("a.txt")) {
            int ch = 0;
            byte[] bs = new byte[10];
            while ((ch = fis.read(bs)) != -1 ) {
                for (byte b : bs) {
                    System.out.print((char)b);
                }
                System.out.println();
                for (int k=0; k<ch; k++) {
                    System.out.print((char)bs[k]);
                }
                System.out.println();
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("end");

    }
}
