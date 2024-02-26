package com.example.splitwisefeb24.commnads;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Command {
    @Override
    public void execute(String command) {
        //Signup
    }

    @Override
    public boolean matches(String command) {
        List<String> words = List.of(command.split(" "));

        return words.size() == 4 && words.get(0).equals(CommandKeywords.registerCommand);
    }
}
