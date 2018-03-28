package calcSettings;

class HelpPrinter implements CalculatorOperator {

    @Override
    public void execute() {
        System.out.println("--------------Avalible commands-------------");

        System.out.println("start - \tstarts program");
        System.out.println("exit  - \tends program");
        System.out.println("help  - \tdisplay help");
        System.out.println("file  - \tinitailize reading data from file");
        System.out.println("start - \tinitialize reading data from external link");

        System.out.println("--------------------------------------------");
    }
}
