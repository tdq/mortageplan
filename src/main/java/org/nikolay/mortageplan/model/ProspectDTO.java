package org.nikolay.mortageplan.model;

import org.nikolay.mortageplan.money.Money;
import org.springframework.lang.NonNull;

import java.util.Objects;

/**
 * Describes information about customer loan
 */
public class ProspectDTO {
    private String customer = "";
    private Money totalLoan = Money.ZERO;
    private double interest;
    private int years;

    @NonNull
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(@NonNull String customer) {
        this.customer = Objects.requireNonNull(customer);
    }

    @NonNull
    public Money getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(@NonNull Money totalLoan) {
        this.totalLoan = Objects.requireNonNull(totalLoan);
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
