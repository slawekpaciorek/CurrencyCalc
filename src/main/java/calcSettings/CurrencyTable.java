package calcSettings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;


class CurrencyTable implements CalculatorOperator {

    BaseCurrency baseCurrency = new BaseCurrency();
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

        try{
            double amount = (double)(Integer.parseInt(inputAmount));
        }catch(InputMismatchException ex){
            ex.printStackTrace();
        }


        out.println();

        out.print("Pick currency that you want," +
                "\nprint in symbol from the list below " +
                "\n[" + getCurrenciesCode() + "] : ");
        input = getCommands.next();

        out.println(currencyList.indexOf(input));

        out.println("You picked " + input + ". Current value is equal to : " );



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
class BaseCurrency{

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

class Currencies extends BaseCurrency{

}




