package dk.cngroup.calc;

import dk.cngroup.exception.DivisionByZeroException;
import dk.cngroup.data.Operator;

public class Calculator {

    InputReader reader;

    public Calculator(String pathToInputFile) throws Exception{
        reader = new InputReader(pathToInputFile);
        reader.read();
        }

        public double calculate() throws RuntimeException {

        Double result = reader.getOperands().getList().getLast();

        while (reader.getOperators().getListItr().hasNext()) {
            Operator currentOperator = reader.getOperators().getListItr().next();
            Double currentOperand = reader.getOperands().getListItr().next();
            switch (currentOperator) {
                case ADDITION:
                    result =  result + currentOperand;
                    break;
                case SUBTRACTION:
                    result = result - currentOperand;
                    break;
                case DIVISION:
                    if (currentOperand == 0){
                        throw new DivisionByZeroException("ERROR: Division by zero in file " + reader.getPathToInput() );
                    }
                    result = result / currentOperand;
                    break;
                case MULTIPLICATION:
                    result = result * currentOperand;
                    break;
            }
        }
        return result;
        }
    }

