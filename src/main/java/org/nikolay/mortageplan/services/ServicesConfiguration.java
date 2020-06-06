package org.nikolay.mortageplan.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfiguration {

    @Value("${prospects.file.csv}")
    private String prospectsFileName;

    @Bean
    public ProspectsService csvProspectsService() {
        return new CsvProspectsService(prospectsFileName);
    }
}
