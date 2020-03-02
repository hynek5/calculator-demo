package dk.cngroup.calc;

import dk.cngroup.Data.Operators;
import dk.cngroup.exception.DivisionByZeroException;
import dk.cngroup.exception.NotNumberException;
import dk.cngroup.exception.OperatorException;

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
            if (e instanceof DivisionByZeroException ||
                    e instanceof OperatorException ||
                    e instanceof NotNumberException
            )
                System.out.print(e.getMessage());
            else {
                e.printStackTrace();
            }
        }

        }
}
