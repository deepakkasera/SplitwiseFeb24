package com.example.splitwisefeb24;

import com.example.splitwisefeb24.commnads.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

@SpringBootApplication
public class SplitwiseFeb24Application {
//    @Autowired
//    private static Command settleUpCommand;
//    @Autowired
//    private Command registerUserCommand;
//
//    SplitwiseFeb24Application(SettleUpCommand settleUpCommand,
//                              RegisterUserCommand registerUserCommand) {
//        this.settleUpCommand= settleUpCommand;
//        this.registerUserCommand = registerUserCommand;
//    }
//
    @Autowired
    private static CommandExecutor commandExecutor;
    @Autowired
    private static SettleUpCommand settleUpCommand;
    @Autowired
    private static RegisterUserCommand registerUserCommand;

//    SplitwiseFeb24Application(CommandExecutor commandExecutor,
//                              SettleUpCommand settleUpCommand,
//                              RegisterUserCommand registerUserCommand) {
//        this.commandExecutor = commandExecutor;
//        this.settleUpCommand = settleUpCommand;
//        this.registerUserCommand = registerUserCommand;
//    }


    public static void main(String[] args) {
        SpringApplication.run(SplitwiseFeb24Application.class, args);

        Scanner scanner = new Scanner(System.in);
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.addCommand(settleUpCommand);
        commandExecutor.addCommand(registerUserCommand);

        while (true) {
            String input = scanner.next(); // 1234 settleUp
            commandExecutor.execute(input);
        }
    }

}
