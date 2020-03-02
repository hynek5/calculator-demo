package testing;

import dk.cngroup.calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {

    public Calculator calculator;
    String tests = "src/test/resources/";
    public Tests() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testOne() throws Exception {
        calculator = new Calculator();
        calculator.readData(tests+"test1.txt");
        Assert.assertEquals(calculator.calculate(),18d);
    }

    @Test
    public void testTwo() throws Exception {
        calculator = new Calculator();
        calculator.readData(tests+"test2.txt");
        Assert.assertEquals(calculator.calculate(),45d);
    }

    @Test
    public void testThree() throws Exception {
        calculator = new Calculator();
        calculator.readData(tests+"test3.txt");
        Assert.assertEquals(calculator.calculate(),1d);
    }

}
