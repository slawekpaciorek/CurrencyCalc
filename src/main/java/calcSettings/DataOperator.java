package calcSettings;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.crypto.Data;
import java.util.Scanner;


class DataOperator implements CalculatorOperator {

    private static CommandFactory commands = CommandFactory.init();

    @Override
    public void execute() {

        Scanner getCommands = new Scanner(System.in);

        System.out.println("--------------------------------------------");
        System.out.println("\tChoose source data :" +
                "\n\n\t\tfile - default source data" +
                "\n\t\tlink - external source data(you have to print in a web adress");
        System.out.println();

        boolean inputValidation = false;
        String input;

        while(!inputValidation){
            System.out.print("\tPrint command : ");
            input = getCommands.next();
            if(input.equals("file")){
                System.out.println();
                System.out.println("\n\tYou choosed default data, proceed next.");
                System.out.println();

                commands.followCommands("display -table");

                inputValidation = true;
            }
            else if(input.equals("link")){
                System.out.println("\n\tWe're working on this, try to read form file");

            }
            else
                System.out.println("\n!!!!!You typed wrong command, try again!!!!!\n");

        }




    }
}