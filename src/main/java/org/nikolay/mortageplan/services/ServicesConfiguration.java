package org.nikolay.mortageplan.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Configures which instance of {@link ProspectsService} should be used.
 * In future release it can be changed by providing more instances and it can be configuration file based
 */
@Configuration
public class ServicesConfiguration {

    @Value("${prospects.file.csv}")
    private String prospectsFileName;

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ProspectsService prospectsService() {
        return new CsvProspectsService(prospectsFileName);
    }
}
