package org.example.server;

import java.io.IOException;

public class ServerMain {

    private final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        CommandManager commandManager = new CommandManagerV1(sessionManager);

        Server server = new Server(8080, commandManager, sessionManager);
        server.start();
    }
}
