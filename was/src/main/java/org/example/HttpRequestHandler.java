package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.example.utility.MyLogger.log;


public class HttpRequestHandler implements Runnable {

    private final Socket socket;


    public HttpRequestHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            process(socket);
        } catch (Exception e) {
            log(e);
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
            if (requestString.startsWith("GET /site1")) {
                site1(writer);
            } else if (requestString.startsWith("GET /site2")) {
                site2(writer);
            } else if (requestString.startsWith("GET /search")) {
                search(writer, requestString);
            } else if (requestString.startsWith("GET / ")) {
                home(writer);
            } else {
                notFound(writer);
            }
            responseToClient(writer);
            log("HTTP response end");

        }
    }


    private void search(PrintWriter writer, String requestString) {
        int startIndex = requestString.indexOf("q=");
        int endIndex = requestString.indexOf(" ", startIndex + 2);
        String searchString = requestString.substring(startIndex, endIndex);
        String[] split = searchString.split("&");

        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>Search</h1>");
        writer.println("<ul>");
        for (String query : split) {
            String[] querySplit = query.split("=");
            writer.println("<li>query: " + querySplit[1] + "</li>");
            writer.println("<li>decode: " +  URLDecoder.decode(querySplit[1], UTF_8) + "</li>");
        }
        writer.println("</ul>");
        writer.flush();
    }


    private void notFound(PrintWriter writer) {
        writer.println("HTTP/1.1 404 Not Found");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>404 - Not Found</h1>");
        writer.flush();
    }


    private void site2(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>Site 2</h1>");
        writer.flush();
    }


    private void site1(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>Site 1</h1>");
        writer.flush();
    }


    private void home(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>Home</h1>");
        writer.println("<ul>");
        writer.println("<li><a href=\"/search?q=hello\">Search</a></li>");
        writer.println("<li><a href=\"/site1\">Site 1</a></li>");
        writer.println("<li><a href=\"/site2\">Site 2</a></li>");
        writer.println("</ul>");
        writer.flush();
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
