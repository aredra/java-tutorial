package org.example.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.utility.MyLogger.log;


public class Server {

    private final int port;
    private final CommandManager commandManager;
    private final SessionManager sessionManager;

    private ServerSocket serverSocket;

    public Server(int port, CommandManager commandManager, SessionManager sessionManager) {
        this.port = port;
        this.commandManager = commandManager;
        this.sessionManager = sessionManager;
    }

    public void start() throws IOException {
        log("Server start.");
        serverSocket = new ServerSocket(port);
        log("Server socket started. port: " + port);

        addShutdownHook();
        running();
    }

    private void addShutdownHook() {
        ShutdownHook shutdownHook = new ShutdownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook, "shutdown-hook"));
    }

    private void running() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                Session session = new Session(socket, commandManager, sessionManager);
                new Thread(session, "session-thread").start();
            }
        } catch (IOException e) {
            log("Server stopped." + e);
        }
    }

    static class ShutdownHook implements Runnable {
        private final ServerSocket serverSocket;
        private final SessionManager sessionManager;

        public ShutdownHook(ServerSocket serverSocket, SessionManager sessionManager) {
            this.serverSocket = serverSocket;
            this.sessionManager = sessionManager;
        }

        @Override
        public void run() {
            log("Server shutdown hook.");
            try {
                sessionManager.clear();
                serverSocket.close();

                Thread.sleep(1000); // 자원 정리 대기
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                log("Server shutdown hook failed.");
            }
        }
    }
}