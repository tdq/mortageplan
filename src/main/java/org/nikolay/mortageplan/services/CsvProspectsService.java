package org.nikolay.mortageplan.services;

import au.com.bytecode.opencsv.CSVReader;
import org.nikolay.mortageplan.model.ProspectDTO;
import org.nikolay.mortageplan.money.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * CSV file based prospects service
 */
class CsvProspectsService implements ProspectsService {

    private static final int REQUIRED_AMOUNT_OF_CELLS = 4;
    private static final int CUSTOMER_CELL_INDEX = 0;
    private static final int TOTAL_LOAN_CELL_INDEX = 1;
    private static final int INTEREST_CELL_INDEX = 2;
    private static final int YEARS_CELL_INDEX = 3;

    private Logger log = LoggerFactory.getLogger(CsvProspectsService.class);

    private final String prospectsFileName;

    /**
     * Create instance of CSV based prospects service
     *
     * @param prospectsFileName file name of file with prospects in csv format
     */
    CsvProspectsService(@NonNull String prospectsFileName) {
        this.prospectsFileName = Objects.requireNonNull(prospectsFileName);
    }

    @NonNull
    @Override
    public List<ProspectDTO> getAllProspects() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(prospectsFileName), ',', '"', 1);
        List<String[]> allRows = reader.readAll();

        return allRows.stream()
                .map(row -> {
                    if (row.length < REQUIRED_AMOUNT_OF_CELLS) {
                        // Going to just skip such rows
                        log.warn("Amount of cells in row is wrong: " + Arrays.toString(row));
                        return null;
                    }

                    try {
                        ProspectDTO dto = new ProspectDTO();
                        dto.setCustomer(row[CUSTOMER_CELL_INDEX]);
                        dto.setTotalLoan(new Money(Double.parseDouble(row[TOTAL_LOAN_CELL_INDEX])));
                        dto.setInterest(Double.parseDouble(row[INTEREST_CELL_INDEX]));
                        dto.setYears(Integer.parseInt(row[YEARS_CELL_INDEX]));

                        return dto;
                    } catch (NumberFormatException e) {
                        throw new IllegalStateException("Format of number is wrong: " + Arrays.toString(row), e);
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
