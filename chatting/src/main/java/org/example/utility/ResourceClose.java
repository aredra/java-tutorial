package org.example.utility;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.example.utility.MyLogger.log;

public class ResourceClose {

    public static void closeAll(Socket socket, DataInputStream input, DataOutputStream output) {
        safeClose(output);
        safeClose(input);
        safeClose(socket);
    }

    private static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                log("Error closing resource: " + e.getMessage());
            }
        }
    }
}
