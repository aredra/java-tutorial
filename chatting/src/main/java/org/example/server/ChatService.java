package org.example.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import static org.example.server.SessionManager.SESSIONS;

public class ChatService {

    private static String MESSAGE = "message";
    private static String USERLIST = "users";

    public void processMessage(String sessionKey, String inputLine, BufferedWriter output) throws IOException {
        UserSocket userSocket = SESSIONS.get(sessionKey);
        if (userSocket == null) {
            output.write("Unregistered user.\n");
            output.flush();
            return;
        }

        String[] split = inputLine.split("\\|");
        String command = split[0];
        if (MESSAGE.equals(command)) {
            String message = split[1];
            String nickname = userSocket.getNickname();
            for (Map.Entry<String, UserSocket> entry : SESSIONS.entrySet()) {
                if (sessionKey.equals(entry.getKey())) {
                    continue;
                }
                BufferedWriter personalOutput = entry.getValue().getOutput();
                personalOutput.write(nickname + ": " + message + "\n");
                personalOutput.flush();
            }
        }

        if (USERLIST.equals(command)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (UserSocket value : SESSIONS.values()) {
                stringBuilder.append(value.getNickname() + "\n");
            }
            BufferedWriter personalOutput = userSocket.getOutput();
            personalOutput.write(stringBuilder.toString());
            personalOutput.flush();
        }
    }
}
