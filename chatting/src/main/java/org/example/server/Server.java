package org.example.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

    public static void main(String[] args) {

        int port = 8080;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket connectedSocket = serverSocket.accept();
                executorService.execute(new SessionManager(connectedSocket, new ChatService()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}