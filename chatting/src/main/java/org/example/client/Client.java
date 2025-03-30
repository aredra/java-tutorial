package org.example.client;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.example.utility.MyLogger.log;

public class Client {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        String host = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(host, port);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            executorService.execute(new CommandWriter(output));
            String inputLine;
            while ((inputLine = input.readLine()) != null) {
                log(inputLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
