package org.nikolay.mortageplan.money;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FixedPaymentCalculatorTest {

    private String client;
    private double totalLoan;
    private int numberOfPayments;
    private double interestPerPayment;
    private String expectedResult;

    @Parameterized.Parameters(name = "{0}: tesing")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { "Juha", 1000, 5, 2, "43.87" },
            { "Karvinen", 4356, 1.27, 6, "62.87" },
            { "Claes Månsson", 1300.55, 8.67, 2, "59.22" },
            { "\"Clarencé,Andersson\"", 2000, 6, 4, "46.97" }
        });
    }

    public FixedPaymentCalculatorTest(String client, double totalLoan, double interestPerYear, int years, String expectedResult) {
        this.client = client;
        this.totalLoan = totalLoan;
        this.numberOfPayments = years * 12;
        this.interestPerPayment = interestPerYear / 1200;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testFixedPaymentPerMonthForSetOfCustomers_valid() {
        Assert.assertEquals(expectedResult, FixedPaymentCalculator.calculateFixedPayment(new Money(totalLoan), numberOfPayments, new Money(interestPerPayment)).toString());
    }
}
