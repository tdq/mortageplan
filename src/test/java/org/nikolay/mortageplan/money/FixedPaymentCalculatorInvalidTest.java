package org.nikolay.mortageplan.money;

import org.junit.Test;

public class FixedPaymentCalculatorInvalidTest {

    @Test(expected = IllegalArgumentException.class)
    public void testFixedPaymentPerMonthWithNegativePaymentsAmount_invalid() {
        FixedPaymentCalculator.calculateFixedPayment(new Money(1000), -1, new Money(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFixedPaymentPerMonthWithZeroPaymentsAmount_invalid() {
        FixedPaymentCalculator.calculateFixedPayment(new Money(1000), 0, new Money(1));
    }
}
