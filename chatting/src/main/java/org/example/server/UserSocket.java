package org.example.server;

import java.io.BufferedWriter;

public class UserSocket {

    private String nickname;
    private BufferedWriter output;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public BufferedWriter getOutput() {
        return output;
    }

    public UserSocket(String nickname, BufferedWriter output) {
        this.nickname = nickname;
        this.output = output;
    }
}
