package calcSettings;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private final Map<String, CalculatorOperator> commands;

    public static CommandFactory init(){

        CommandFactory result = new CommandFactory();

        result.commands.put("menu", new MenuPrinter());
        result.commands.put("exit", () -> System.out.println("Thank you for using our services! See you soon!"));
        result.commands.put("error", ()-> System.out.println("Invalid command, print in again"));
        result.commands.put("start", new DataOperator());
        result.commands.put("help", new HelpPrinter());
        result.commands.put("display -table", new CurrencyTable());


        return result;
    }

    private CommandFactory(){

        commands = new HashMap<>();

    }

    public void followCommands(String input){

        //unknow instructions

        if(!commands.containsKey(input)){
            input = "error";
        }

        commands.get(input).execute();
    }

}
