package com.example.splitwisefeb24.commnads;

public interface Command {
    void execute(String command);
    boolean matches(String command);
}
