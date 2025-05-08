package org.example.server;

import java.io.IOException;

public class CommandManagerV1 implements CommandManager {

    private final static String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    public CommandManagerV1(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {

        if (totalMessage.startWith("/join")) {
            String[] spilt = totalMessage.split(DELIMITER);
            String username = split[1];
            session.setUsername(username);
            sessionManager.sendAll(username + " visit.");
        } else if (totalMessage.startWith("/message")) {
            String[] spilt = totalMessage.split(DELIMITER);
            String message = split[1];
            sessionManager.sendAll("[" + session.getUsername() + "]: " + message);
        } else if (totalMessage.startWith("/change")) {
            String[] spilt = totalMessage.split(DELIMITER);
            String changeName = split[1];
            sessionManager.sendAll(session.getUsername() + " -> " + changeName);
            session.setUsername(changeName);
        } else if (totalMessage.startWith("/users")) {
            List<String> usernames = sessionManager.getAllUsername();
            StringBuffer sb = new StringBuffer();
            sb.append("Total users: ").append(usernames.size()).append("\n");
            for (String username : usernames) {
                sb.append(username).append("\n");
            }
            session.send(sb.toString());
        } else if (totalMessage.startsWith("/exit")) {
            throw new IOException(totalMessage);
        } else {
            session.send("Not supported message: " + totalMessage);
        }
    }
}
