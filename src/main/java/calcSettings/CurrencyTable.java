package calcSettings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

import static java.lang.System.out;


class CurrencyTable implements CalculatorOperator {

    Currencies baseCurrency = new Currencies();
    ArrayList<Currencies> currencies = new ArrayList<Currencies>();

    CurrencyTable currencyTable = null;



    @Override
    public void execute() {

        Scanner getCommands = new Scanner(System.in);
        String inputAmount;
        String input;

        try (Reader reader = new InputStreamReader(CurrencyTable.class.getResourceAsStream("/currencies.json"), "UTF-8")) {

            Gson gson = new GsonBuilder().create();
            currencyTable = gson.fromJson(reader, CurrencyTable.class);


        } catch (IOException exception) {
            exception.printStackTrace();
        }

        out.println(currencyTable.toString());

        double baseCurrencyValue = currencyTable.baseCurrency.value;

        ArrayList<Currencies> currencyList = currencyTable.currencies;

        out.print("Set amount do you want to change : ");
        inputAmount = getCommands.next();

        double amount = 0;
        try{
            amount = (double)(Integer.parseInt(inputAmount));
        }catch(InputMismatchException ex){
            ex.printStackTrace();
        }

        out.println();
        out.print("Pick currency that you want," +
                "\nprint in symbol from the list below " +
                "\n[" + getCurrenciesCode() + "] : ");
        input = getCommands.next();


        out.println("'----------------------");
        out.println("Your amount : " + amount);
        out.println("You picked " + input + ". Current value is equal to : " + getCurrencyValue(input));
        String pickedCurrency = input;
        double currencyValue = getCurrencyValue(input);
        out.println("------------------------");
        out.print("If you want to change money type 'yes', if you want to make another change type 'no' :");
        input = getCommands.next();
        out.println();
        if(input.equals("yes")){
            double recivedMoney = amount / currencyValue;
            recivedMoney = Math.round(recivedMoney * 100) /100;
            out.println("You recive : " + recivedMoney + " " + pickedCurrency + " .");
        }




    }

    private String getCurrenciesCode() {
        String code = "";
        for(int i = 0; i < currencyTable.currencies.size(); i++){
            if(i < (currencyTable.currencies.size()-1) )
                code += currencyTable.currencies.get(i).code + ", ";

            else
                code += currencyTable.currencies.get(i).code;
        }

        return code;
    }

    private double getCurrencyValue(String input){
        double currencyValue = 0;
            for(int i = 0;i < currencyTable.currencies.size(); i++ ){
                if (input.equals(currencyTable.currencies.get(i).code)) {
                    currencyValue = currencyTable.currencies.get(i).value;
                }
            }
            return currencyValue;
    }

    @Override
    public String toString() {

        return "--------------------------------------------------" +
                "\nCurrency Table : " +
                "\n\tBase Currency : " + baseCurrency  +
                ", " +
                "\n\tAvalible Currencies : " + currencies  +
                "\n-----------------------------------------------";
    }
}
class Currencies{

    String code;
    String name;
    double value;

    @Override
    public String toString() {
        return "\n\t\t{" +
                "code = " + code +
                ", name = " + name +
                ", value = " + value  +
                '}';
    }
}





