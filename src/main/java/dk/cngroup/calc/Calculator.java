package dk.cngroup.calc;

import dk.cngroup.Data.Operands;
import dk.cngroup.Data.Operators;
import dk.cngroup.exception.DivisionByZeroException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Calculator {

    String pathToFile;
    Operators operators;
    Operands operands;
    Double basicOperand = 0d;
    static final String basicOperator = "apply";

    public Calculator() throws Exception{
        operators = new Operators();
        operands = new Operands();
        }

    public void delete() {
        basicOperand = 0d;
        operators = new Operators();
        operands = new Operands();
    }
    /**
     * Reads data form txt file describing set of instructions,
     * the example of valid set of instructions:
     * operator operand
     * ...
     * apply basic_operand
     * @param pathToFile
     * @return
     * @throws Exception
     */
    public int readData(String pathToFile) throws Exception {
        this.pathToFile = pathToFile;
        String[] array;
        int lineNum = 0;
        BufferedReader br = new BufferedReader(new FileReader(new File(pathToFile)));
        Scanner sc = new Scanner(br);
        while (sc.hasNextLine()) {
            lineNum++;
            array = sc.nextLine().split(" ");
            if (array.length != 2) {
                throw new Exception("ERROR: Invalid input file, more than two elements on line "+ lineNum + " in file" + pathToFile);
            }
            if (array[0].compareTo(basicOperator) == 0) {
                basicOperand = Double.parseDouble(array[1]);
                return 0;
            }
            operators.addToList(array[0]);
            operands.addToList(Double.parseDouble(array[1]));
            }
        return 0;
        }

        public double calculate() throws Exception {
        Double result = basicOperand;

        while (operators.listItr.hasNext()) {
            Operators.Operator currentOperator = operators.listItr.next();
            Double currentOperand = operands.listItr.next();
            switch (currentOperator) {
                case ADDITION:
                    result =  result + currentOperand;
                    break;
                case SUBTRACTION:
                    result = result - currentOperand;
                    break;
                case DIVISION:
                    if (currentOperand == 0){
                        throw new DivisionByZeroException("ERROR: Division by zero in file " + pathToFile );
                    }
                    result = result / currentOperand;
                    break;
                case MULTIPLICATION:
                    result = result * currentOperand;
                    break;
            }
        }
        return result.doubleValue();
        }
    }

