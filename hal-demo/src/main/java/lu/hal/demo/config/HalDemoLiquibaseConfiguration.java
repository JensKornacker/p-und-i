package lu.hal.demo.config;

import java.sql.Connection;
import javax.sql.DataSource;

import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.integration.spring.SpringLiquibase;
import liquibase.resource.ResourceAccessor;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class HalDemoLiquibaseConfiguration {

        @Bean
        @ConfigurationProperties(prefix = "spring.liquibase.hal-demo")
        public LiquibaseProperties halDemoLiquibaseProperties() {
            return new LiquibaseProperties();
        }

        @Bean
        @DependsOn("liquibase")
        public SpringLiquibase cashALiquibase(final DataSource dataSource) {

            final var properties = halDemoLiquibaseProperties();

            final var liquibase = new SpringLiquibase() {
                @Override
                protected Database createDatabase(Connection c, ResourceAccessor resourceAccessor)
                        throws DatabaseException {
                    final var db = super.createDatabase(c, resourceAccessor);
                    db.setAutoCommit(true);
                    return db;
                }
            };
            liquibase.setDataSource(dataSource);
            liquibase.setChangeLog(properties.getChangeLog());
            liquibase.setDatabaseChangeLogTable(properties.getDatabaseChangeLogTable());
            liquibase.setDatabaseChangeLogLockTable(properties.getDatabaseChangeLogLockTable());
            liquibase.setContexts(properties.getContexts());
            liquibase.setDefaultSchema(properties.getDefaultSchema());
            liquibase.setLiquibaseSchema(properties.getLiquibaseSchema());
            liquibase.setDropFirst(properties.isDropFirst());
            liquibase.setShouldRun(properties.isEnabled());
            liquibase.setLabels(properties.getLabels());
            liquibase.setChangeLogParameters(properties.getParameters());
            liquibase.setRollbackFile(properties.getRollbackFile());
            return liquibase;

        }


}
