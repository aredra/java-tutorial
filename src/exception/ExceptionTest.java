package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args){

        //try-catch-finally
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream("a.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fis.close();
//                System.out.println("finally");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        //try-with-resources
        try(FileInputStream fis = new FileInputStream("a.txt")) {
            System.out.println("start-try-with");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("end");
    }
}
