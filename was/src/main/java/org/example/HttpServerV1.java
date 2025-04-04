package org.example;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.example.utility.MyLogger.log;


public class HttpServerV1 {

    private final int port;


    public HttpServerV1(int port) {
        this.port = port;
    }


    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        log("Was start, port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            process(socket);
        }
    }


    private void process(Socket socket) throws IOException {
        try (socket;
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8)) {

            String requestString = requestToString(reader);
            if (requestString.contains("/favicon.ico")) {
                log("favicon request");
                return;
            }
            log("HTTP request: " + requestString);

            log("HTTP response start");
            sleep(3000);
            responseToClient(writer);
            log("HTTP response end");

        }
    }


    private void responseToClient(PrintWriter writer) throws IOException {
        String body = "<h1>Hello world!</h1>";
        int length = body.getBytes(UTF_8).length;

        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\r\n");
        sb.append("Content-Type: text/html\r\n");
        sb.append("Content-Length: ").append(length).append("\r\n");
        sb.append("\r\n");
        sb.append(body);

        log("HTTP response: " + sb);

        writer.println(sb);
        writer.flush();
    }


    private String requestToString(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }


    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
