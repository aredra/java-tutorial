package org.example.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import static org.example.utility.MyLogger.log;

public class ReadHandler implements Runnable {

    private final DataInputStream input;
    private final Client client;
    public boolean closed = false;

    public ReadHandler(DataInputStream input, Client client) {
        this.input = input;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
            }
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        closed = true;
        log("ReadHandler close");
    }
}
