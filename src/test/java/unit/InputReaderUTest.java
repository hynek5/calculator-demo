package unit;

import dk.cngroup.calc.InputReader;
import dk.cngroup.data.Operators;
import dk.cngroup.exception.OperandException;
import dk.cngroup.exception.OperatorException;
import dk.cngroup.exception.WrongLineContent;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class InputReaderUTest {

    private String testDataDir = System.getProperty("user.dir") + "/src/test/resources/unit/";
    private String validPath = testDataDir + "readFileTest.txt";
    private String wrongOperandFile = testDataDir + "wrongOperandFile.txt";
    private String wrongOperatorFile = testDataDir + "wrongOperator.txt";
    private String wrongLineContentFile = testDataDir + "wrongLineContent.txt";

    public InputReaderUTest() {
    }

    @Test
    public void readFile() throws Exception {
        InputReader reader = new InputReader(validPath);
        reader.read();
    }

    @Test
    public void fileNotFound() {
        Assert.assertThrows(FileNotFoundException.class, () -> {
            InputReader reader;
            reader = new InputReader(validPath + "xxx");
            reader.read();
        });
    }

    @Test
    public void wrongOperand() {
        Assert.assertThrows(OperandException.class, () -> {
            InputReader reader;
            reader = new InputReader(wrongOperandFile);
            reader.read();
        });
    }

    @Test
    public void wrongOperator() {
        Assert.assertThrows(OperatorException.class, () -> {
            InputReader reader;
            reader = new InputReader(wrongOperatorFile);
            reader.read();
        });
    }

    @Test
    public void wrongLineContent() {
        Assert.assertThrows(WrongLineContent.class, () -> {
            InputReader reader;
            reader = new InputReader(wrongLineContentFile);
            reader.read();
        });

}
}
