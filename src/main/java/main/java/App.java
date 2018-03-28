package main.java;

import java.util.Scanner;
import calcSettings.CommandFactory;

public class App {

    private static CommandFactory commands = CommandFactory.init();

    public static void main(String[] args) {

        Scanner getCommands = new Scanner(System.in);
        boolean stopExecute = false;

        while(!stopExecute){

            commands.followCommands("menu");

            System.out.print("\tPrint command: ");

            String input;
            input = getCommands.next();

            stopExecute = input.equals("exit");

            System.out.println();
            commands.followCommands(input);
            System.out.println();
        }

        getCommands.close();

    }
}