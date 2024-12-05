package com.example;

import com.example.cli.CommandExecutor;

public class Main {
    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutor();
        args =new String[]{ "generate","-l","-o","-a" };
        executor.doExecute(args);
    }
}