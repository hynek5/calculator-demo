package unit;

import dk.cngroup.calc.Calculator;
import dk.cngroup.calc.InputReader;
import dk.cngroup.exception.DivisionByZeroException;
import dk.cngroup.exception.WrongLineContent;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Calculation {

    public Calculator calculator;
    String testDataDir = "src/test/resources/unit/";
    public Calculation() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testOne() throws Exception {
        calculator.readData(testDataDir + "test1.txt");
        Assert.assertEquals(calculator.calculate(),18d);
    }

    @Test
    public void testTwo() throws Exception {
        calculator.readData(testDataDir + "test2.txt");
        Assert.assertEquals(calculator.calculate(),45d);
    }

    @Test
    public void testThree() throws Exception {
        calculator.readData(testDataDir + "test3.txt");
        Assert.assertEquals(calculator.calculate(),1d);
    }

    @Test
    public void DivisionByZero() throws Exception {
        calculator.readData(testDataDir + "divisionByZero.txt");
        Assert.assertThrows(DivisionByZeroException.class, () -> {
            calculator.calculate();
        });
    }
}
