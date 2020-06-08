package org.nikolay.mortageplan.money;

import org.springframework.lang.NonNull;
import java.util.Objects;

/**
 * Calculates fixed payments for customers of their loans
 */
public class FixedPaymentCalculator {

    private static final int MINIMUM_PAYMENTS_AMOUNT = 1;

    /**
     * Calculate customer loan fixed payments
     *
     * @param totalLoan total customer loan
     * @param numberOfPayments amount of payments customer should make
     * @param interestPerPayment interest payed per each payment
     *
     * @throws IllegalArgumentException if number of payments is not allowed
     *
     * @return {@link Money} represents customer fixed payment for his loan per payment period
     */
    @NonNull
    public static Money calculateFixedPayment(@NonNull final Money totalLoan, int numberOfPayments, @NonNull final Money interestPerPayment) {
        Objects.requireNonNull(totalLoan, "total loan can't be null");
        Objects.requireNonNull(interestPerPayment, "interest can't be null");

        if(numberOfPayments < MINIMUM_PAYMENTS_AMOUNT) {
            throw new IllegalArgumentException("Number of payments can't be less than " + MINIMUM_PAYMENTS_AMOUNT);
        }

        if(Money.ZERO.equals(interestPerPayment)) {
            return totalLoan.div(new Money(numberOfPayments));
        }

        final Money coefficient = interestPerPayment.add(Money.ONE).pow(numberOfPayments);

        return totalLoan.mul(interestPerPayment.mul(coefficient)).div(coefficient.sub(Money.ONE));
    }
}
