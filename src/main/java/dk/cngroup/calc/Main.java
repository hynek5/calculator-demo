package dk.cngroup.calc;

import static dk.cngroup.logging.BaseLogger.logger;

public class Main {

    static String pathToFile;

    public static void main(String[] args) {

        try {
            if (args.length == 0) {
                System.out.print("ERROR: No instruction file specified");
                System.exit(1);
            }
            pathToFile = args[0];
            Calculator calculator = new Calculator();
            calculator.readData(pathToFile);
            System.out.print("Result is " + calculator.calculate());
        } catch (Exception e) {
                logger.error("Fail during the computation:",e);
                System.out.println("Fail, unexpected error during the processing.");
                System.exit(-1);
            }
        }

}
