package byteStream;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInt {
    public static void main(String[] args) throws IOException {
        System.out.println("입력: ");
        int ch;
        InputStreamReader isr = new InputStreamReader(System.in);
//        System.in.read();

        while ((ch = isr.read()) !='\n') {
            System.out.println(ch);
            System.out.println((char)ch);
        }
    }
}
