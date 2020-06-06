package org.nikolay.mortageplan.util;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.Objects;

public class FixedPaymentCalculator {

    private static final int MINIMUM_PAYMENTS_AMOUNT = 1;

    /**
     *
     * @param totalLoan
     * @param numberOfPayments
     * @param interestPerPayment
     *
     * @throws IllegalArgumentException if number of payments is not allowed
     *
     * @return
     */
    public static BigDecimal calculateFixedPayment(@NonNull BigDecimal totalLoan, int numberOfPayments, @NonNull BigDecimal interestPerPayment) {
        Objects.requireNonNull(totalLoan, "total loan can't be null");
        Objects.requireNonNull(interestPerPayment, "interest can't be null");

        if(numberOfPayments < MINIMUM_PAYMENTS_AMOUNT) {
            throw new IllegalArgumentException("Number of payments can't be less than " + MINIMUM_PAYMENTS_AMOUNT);
        }

        if(BigDecimal.ZERO.equals(interestPerPayment)) {
            return totalLoan.divide(BigDecimal.valueOf(numberOfPayments));
        }

        // TODO get rid of java.Math
        BigDecimal coefficient = interestPerPayment.add(BigDecimal.ONE).pow(numberOfPayments);

        return totalLoan.multiply(interestPerPayment.multiply(coefficient)).divide(coefficient.subtract(BigDecimal.ONE));
    }
}
