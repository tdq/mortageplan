package org.nikolay.mortageplan.model;

import org.nikolay.mortageplan.money.Money;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class ProspectDTO {
    private String customer;
    private Money totalLoan = Money.ZERO;
    private double interest;
    private int years;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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
