package at.phactum.config;

import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
public class LiquibaseConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.liquibase")
    public LiquibaseProperties serviceLiquibaseProperties() {

        return new LiquibaseProperties();

    }

    @Bean("liquibase")
    public SpringLiquibase serviceLiquibase(final DataSource dataSource) {

        final var properties = serviceLiquibaseProperties();

        final var liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(properties.getChangeLog());
        liquibase.setDatabaseChangeLogTable(properties.getDatabaseChangeLogTable());
        liquibase.setDatabaseChangeLogLockTable(properties.getDatabaseChangeLogLockTable());
        liquibase.setContexts(properties.getContexts());
        liquibase.setDefaultSchema(properties.getDefaultSchema());
        liquibase.setLiquibaseSchema(properties.getLiquibaseSchema());
        liquibase.setDropFirst(properties.isDropFirst());
        liquibase.setShouldRun(properties.isEnabled());
        // liquibase.setLabels(properties.getLabels());
        liquibase.setChangeLogParameters(properties.getParameters());
        liquibase.setRollbackFile(properties.getRollbackFile());
        return liquibase;

    }

}
