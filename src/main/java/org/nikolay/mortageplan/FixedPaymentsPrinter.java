package org.nikolay.mortageplan;

import org.nikolay.mortageplan.money.FixedPaymentCalculator;
import org.nikolay.mortageplan.money.Money;
import org.nikolay.mortageplan.services.ProspectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FixedPaymentsPrinter implements CommandLineRunner {

    private static final String CUSTOMER_INFO_FORMAT = "%s wants to borrow %s € for a period of %d years and pay %s € each month";
    private static final int MONTHS_IN_YEAR = 12;

    @Autowired
    private ProspectsService csvProspectsService;

    public static void main(String[] args) {
        SpringApplication.run(FixedPaymentsPrinter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        csvProspectsService.getAllProspects().stream()
            .forEach(dto -> System.out.println(String.format(CUSTOMER_INFO_FORMAT,
                    dto.getCustomer(), dto.getTotalLoan(), dto.getYears(),
                    FixedPaymentCalculator.calculateFixedPayment(
                            dto.getTotalLoan(),
                            dto.getYears() * MONTHS_IN_YEAR,
                            new Money(dto.getInterest() / 1200)))));
    }
}
