package dk.cngroup.calc;

import dk.cngroup.Data.Operators;
import dk.cngroup.exception.DivisionByZeroException;
import dk.cngroup.exception.OperatorException;

public class Main {

    static String pathToFile = "C://Temp//TestData.txt";

    public static void main(String[] args) {

        try {

            Calculator calculator = new Calculator();
            calculator.readData(pathToFile);
            //calculator.calculate();
            System.out.print("Result is " + calculator.calculate());
        } catch (Exception e) {
            if (e instanceof DivisionByZeroException || e instanceof OperatorException )
                System.out.print(e.getMessage());
            else {
                e.printStackTrace();
            }
        }

        }
}
