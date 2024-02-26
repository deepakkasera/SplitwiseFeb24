package com.example.splitwisefeb24.commnads;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void execute(String input) {
        for (Command command : commands) { //settleUpCommand
            if (command.matches(input)){
                command.execute(input);
            }
        }
    }
}
