package dk.cngroup.calc;

import dk.cngroup.data.Operands;
import dk.cngroup.data.Operators;
import dk.cngroup.exception.OperandException;
import dk.cngroup.exception.OperatorException;
import dk.cngroup.exception.WrongLineContent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import static dk.cngroup.logging.BaseLogger.logger;

public class InputReader {

    private String pathToInput;
    static final String endOperator = "apply";
    private Operators operators;
    private Operands operands;

    public InputReader(String pathToInput) throws Exception {
        File input = new File(pathToInput);
        if (!input.exists()) {
            throw new FileNotFoundException("File " + pathToInput + " not found");
        }
        this.pathToInput = input.getAbsolutePath();
        operands = new Operands();
        operators = new Operators();
    }

    public Operators getOperators() {
        return operators;
    }

    public Operands getOperands() {
        return operands;
    }

    public String getPathToInput() {
        return pathToInput;
    }

    public void read() throws RuntimeException, IOException {
        logger.debug("Class {}, reading from: {}", this.getClass().getName(), pathToInput);

        AtomicBoolean ignore = new AtomicBoolean(true);

        Stream<String> stream = Files.lines(Paths.get(pathToInput));
                    stream.takeWhile(tmpIgnore -> ignore.get()).forEach(line -> {
                    String[] lineContent = line.split(" ");
                    if (lineContent.length != 2) {
                        //System.out.println("Invalid input file, more than two elements on line: in file,exitting " + pathToInput);
                        throw new WrongLineContent("More than two elements on line:\"" + line + "\" in file: " + pathToInput);

                    }
                    if (!operands.isValid(lineContent[1])) {
                        //System.out.println("Second positional parameter " + lineContent[1] + " in " + pathToInput +" is not valid operand,exitting.");
                        throw new OperandException(lineContent[1] + " is not valid operand");

                    }
                    if (!operators.isValid(lineContent[0])) {
                        //System.out.println("First positional parameter" + lineContent[0]+ " in " + pathToInput + " is not valid operator,exitting.");
                        throw new OperatorException(lineContent[0] + " is not valid operator");
                    }
                    if (lineContent[0].toLowerCase().equals(endOperator)) {
                        ignore.set(false);
                    }

                });
        operands.updateItr();
        operators.updateIter();
    }
}
