package org.example.server;

import java.io.IOException;

public interface CommandManager {
    void execute(String totalMessage, Session session) throws IOException;
}
