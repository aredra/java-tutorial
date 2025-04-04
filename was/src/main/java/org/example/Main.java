package org.example;


import java.io.IOException;


public class Main {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServerV1 httpServerV1 = new HttpServerV1(PORT);
        httpServerV1.start();
    }
}