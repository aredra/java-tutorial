package byteStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputTest {
    public static void main(String[] args) {


        System.out.println("start");
//        FileInputStream fis = null;
//        try {
//            int ch = 0;
//            fis = new FileInputStream("a.txt");
//            while ((ch = fis.read()) != -1 ) {
//                System.out.print((char)ch);
//            }
//            System.out.println();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fis.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        try (FileInputStream fis = new FileInputStream("a.txt")) {
            int ch = 0;
            while ((ch = fis.read()) != -1 ) {
                System.out.print((char)ch);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
