package org.example.server;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static org.example.utility.MyLogger.log;

public class SessionManager implements Runnable {

    public static final ConcurrentHashMap<String, UserSocket> SESSIONS = new ConcurrentHashMap<>();
    private static final String[] COMMANDS = {"join", "message", "change", "users", "exit"};
    private static final String EXIT = "exit";
    private static final String JOIN = "join";
    private static final String CHANGE = "change";

    private final Socket socket;
    private final ChatService chatService;
    private final List<String> commandList;

    public SessionManager(Socket socket, ChatService chatService) {
        this.socket = socket;
        this.chatService = chatService;
        this.commandList = Arrays.asList(COMMANDS);
    }

    @Override
    public void run() {
        try (socket;
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            String hostAddress = socket.getInetAddress().getHostAddress();
            int port = socket.getPort();
            String key = hostAddress + ":" + port;

            output.write("Server Connected\n");
            output.flush();

            String inputLine;
            while ((inputLine = input.readLine()) != null) {
                log(inputLine);
                inputLine = inputLine.trim();
                String command = inputLine.split("\\|")[0];
                if (!commandList.contains(command)) {
                    output.write("Server response: Wrong commnad: " + command + "\n");
                    output.flush();
                    continue;
                }
                if (checkExit(key, command, output, input)) {
                    break;
                }
                if (checkJoin(key, inputLine, output)) {
                    continue;
                }
                if (checkNickNameChange(key, inputLine, output)) {
                    continue;
                }
                chatService.processMessage(key, inputLine, output);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkNickNameChange(String key, String message, BufferedWriter output) throws IOException {
        String[] split = message.split("\\|");
        if (CHANGE.equals(split[0])) {
            SESSIONS.get(key).setNickname(split[1]);
            output.write("Nickname change success.\n");
            output.flush();
            return true;
        }
        return false;
    }

    private boolean checkJoin(String key, String message, BufferedWriter output) throws IOException {
        String[] split = message.split("\\|");
        if (JOIN.equals(split[0])) {
            SESSIONS.put(key, new UserSocket(split[1], output));
            output.write("Join success.\n");
            output.flush();
            return true;
        }
        return false;
    }

    private boolean checkExit(String key, String command, BufferedWriter output, BufferedReader input) throws IOException {
        if (EXIT.equals(command)) {
            SESSIONS.remove(key);
            output.close();
            input.close();
            socket.close();
            return true;
        }
        return false;
    }
}
