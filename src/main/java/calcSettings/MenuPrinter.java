package calcSettings;

class MenuPrinter implements CalculatorOperator {
    @Override
    public void execute() {
        System.out.println("-------Welcome in currency calulator--------");
        System.out.println();
        System.out.println("\tPrint in :" +
                "\n\n\t\tstart - to run calulator" +
                "\n\t\texit - to exit calulator");
        System.out.println();
        System.out.println("--------------------------------------------");
    }
}