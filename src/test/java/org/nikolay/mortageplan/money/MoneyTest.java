package org.nikolay.mortageplan.money;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MoneyTest {

    private Money a;
    private Money b;
    private char operation;
    private String expected;

    @Parameterized.Parameters(name = "{0} {1} {2} = {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
//            {1, 1, '+', "2.0"},
//            {2, 2, '+', "4.0"},
//            {1.5, 1.5, '+', "3.0"},
//            {1.05, 1.05, '+', "2.1"},
//            {1.005, 1.005, '+', "2.01"},
//            {1.0005, 1.0005, '+', "2.0"},
//            {1, 1, '-', "0.0"},
//            {1.5, 0.5, '-', "1.0"},
//            {1.5, 0.05, '-', "1.45"},
//            {1.5, 0.005, '-', "1.5"},       // Actually Money in this case has value 14950, but because of rounding it will be displayed as 1.5
//            {1.5, 0.0005, '-', "1.5"},
//            {1, 1, '*', "1.0"},
//            {1, 0, '*', "0.0"},
//            {2, 2, '*', "4.0"},
//            {1.5, 1.5, '*', "2.25"},
//            {1.05, 1.05, '*', "1.1"},
//            {1.005, 1.005, '*', "1.01"},
//            {1.0005, 1.0005, '*', "1"},
//            {1, 1, '/', "1.0"},
//            {2, 1, '/', "2.0"},
//            {2, 2, '/', "1.0"},
//            {4, 2, '/', "2.0"},
//            {0, 2, '/', "0.0"},
//            {1.5, 0.5, '/', "3.0"},
//            {1.05, 0.05, '/', "21.0"},
            {1.005, 0.005, '/', "201.0"},
//            {1.0005, 0.0005, '/', "2001.0"},
            //{0, 0, '^', "1"},
            //{1, 0, '^', "1"},
            //{2, 2, '^', "4"}
        });
    }

    public MoneyTest(double a, double b, char operation, String expected) {
        this.a = new Money(a);
        this.b = new Money(b);
        this.operation = operation;
        this.expected = expected;
    }

    @Test
    public void testMoneyArithmeticOperations_valid() {
        switch (operation) {
            case '+': Assert.assertEquals(this.expected, a.add(b).toString()); break;
            case '-': Assert.assertEquals(this.expected, a.sub(b).toString()); break;
            case '*': Assert.assertEquals(this.expected, a.mul(b).toString()); break;
            case '/': Assert.assertEquals(this.expected, a.div(b).toString()); break;
            //case '^': Assert.assertEquals(this.expected, a.pow(b).toString()); break;
        }
    }
}
