package charStream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("output.txt", true);
        fw.write('A');
        char[] buf = {'R', 'E', 'D', 'R', 'A'};

        fw.write(buf);
        fw.write("Test");
        fw.write(buf, 2, 2);
        fw.close();

        System.out.println("end");
    }
}
