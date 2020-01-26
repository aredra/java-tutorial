package subStream;

import java.io.*;
import java.net.Socket;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        long ms = 0;
        try (FileInputStream fis = new FileInputStream("a.zip");
             FileOutputStream fos = new FileOutputStream("copy.zip");
             BufferedInputStream bis = new BufferedInputStream(fis);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            ms = System.currentTimeMillis();

            int i;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }

            ms = System.currentTimeMillis() - ms;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ms);

        Socket socket = new Socket();
        BufferedReader isr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        isr.readLine();
    }
}
