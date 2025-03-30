package org.example.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.example.utility.MyLogger.log;

public class CommandWriter implements Runnable {

    private static final String[] COMMANDS = {"join", "message", "change", "users", "exit"};
    private static final String EXIT = "exit";

    private final BufferedWriter output;
    private final List<String> commandList;

    public CommandWriter(BufferedWriter output) {
        this.output = output;
        this.commandList = Arrays.asList(COMMANDS);
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            try {
                String message = new Scanner(System.in).nextLine();
                String command = message.trim().split("\\|")[0].toLowerCase();
                if (!commandList.contains(command)) {
                    log("Wrong chat format: " + message);
                    continue;
                }
                output.write(message);
                output.newLine();
                output.flush();
                running = !EXIT.equals(command);
            } catch (IOException e) {
                log(e);
            }
        }
    }
}
