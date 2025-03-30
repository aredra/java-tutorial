package org.example.client;

import java.io.*;
import java.net.Socket;

import static org.example.utility.MyLogger.log;
import static org.example.utility.ResourceClose.closeAll;

public class Client {

    private final String host;
    private final int port;

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    private ReadHandler readHandler;
    private WriteHandler writeHandler;
    private boolean closed = false;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        log("Starting Client");
        socket = new Socket(host, port);
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());

        readHandler = new ReadHandler(input, this);
        writeHandler = new WriteHandler(output, this);

        Thread readThread = new Thread(readHandler, "ReadHandler");
        Thread writeThread = new Thread(writeHandler, "WriteHandler");
        readThread.start();
        writeThread.start();
    }

    public synchronized void close() {
        if (closed) {
            return;
        }
        writeHandler.close();
        readHandler.close();
        closeAll(socket, input, output);
        log("Client closed.");
        closed = true;
    }

}
