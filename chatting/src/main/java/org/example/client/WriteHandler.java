package org.example.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.example.utility.MyLogger.log;

public class WriteHandler implements Runnable {

    private static final String DELIMITER = "|";

    private final DataOutputStream output;
    private final Client client;

    private boolean closed = false;

    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            String username = inputUsername(scanner);
            output.writeUTF("/join" + DELIMITER + username);

            while (true) {
                String toSend = scanner.nextLine(); // 블로킹
                if (toSend.isEmpty()) {
                    continue;
                }
                if (toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    break;
                }

                if (toSend.startsWith("/")) {
                    output.writeUTF(toSend);
                } else {
                    output.writeUTF("/message" + DELIMITER + toSend);
                }
            }
        } catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    private String inputUsername(Scanner scanner) {
        System.out.println("Input username.");
        String username;
        do {
            username = scanner.nextLine();
        } while (username.isEmpty());
        return username;
    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        try {
            System.in.close();  // 사용자 입력 exit
        } catch (IOException e) {
            log(e);
        }
        closed = true;
        log("WriteHandler closed.");
    }
}
