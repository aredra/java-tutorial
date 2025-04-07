package org.example;


import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.example.utility.MyLogger.log;


public class HttpServerV1 {

    private final int             port;
    private final ExecutorService es = Executors.newFixedThreadPool(10);


    public HttpServerV1(int port) {
        this.port = port;
    }


    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        log("Was start, port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            es.submit(new HttpRequestHandler(socket));
        }
    }
}
