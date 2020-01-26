package charStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        //socket 통신은 무조건 byte 단위로 입출력 그런 경우 보조스트림 사용
        FileInputStream fis = new FileInputStream("a.txt");
        InputStreamReader isr = new InputStreamReader(fis);

        int i;
        while ((i = isr.read()) != -1) {
            System.out.println((char)i);
        }
        fis.close();
    }
}
