package org.nikolay.mortageplan;

import org.nikolay.mortageplan.money.FixedPaymentCalculator;
import org.nikolay.mortageplan.money.Money;
import org.nikolay.mortageplan.services.ProspectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Prints fixed monthly payments for customers for their loans
 */
@SpringBootApplication
public class FixedPaymentsPrinter implements CommandLineRunner {

    private static final String CUSTOMER_INFO_FORMAT = "%s wants to borrow %s € for a period of %d years and pay %s € each month";
    private static final int MONTHS_IN_YEAR = 12;
    private static final int INTEREST_PER_MONTH_COEFFICIENT = 1200;

    @Autowired
    private ProspectsService prospectsService;

    public static void main(String[] args) {
        SpringApplication.run(FixedPaymentsPrinter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        prospectsService.getAllProspects()
            .forEach(dto -> {
                Money paymentPerMonth = FixedPaymentCalculator.calculateFixedPayment(
                        dto.getTotalLoan(),
                        dto.getYears() * MONTHS_IN_YEAR,
                        new Money(dto.getInterest() / INTEREST_PER_MONTH_COEFFICIENT));

                System.out.println(formatCustomerInfo(dto.getCustomer(), dto.getTotalLoan(), dto.getYears(), paymentPerMonth));
            });
    }

    private String formatCustomerInfo(String customer, Money totalLoan, int years, Money paymentPerMonth) {
        return String.format(CUSTOMER_INFO_FORMAT, customer, totalLoan, years, paymentPerMonth);
    }
}
