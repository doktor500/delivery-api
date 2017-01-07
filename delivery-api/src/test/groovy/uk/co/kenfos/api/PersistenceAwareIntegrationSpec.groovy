package uk.co.kenfos.api

import org.springframework.cache.annotation.Cacheable
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.jdbc.JdbcTestUtils

import static uk.co.kenfos.api.Database.tables

@SuppressWarnings('AbstractClassWithoutAbstractMethod')
abstract class PersistenceAwareIntegrationSpec extends IntegrationSpec implements ApplicationContextAware {

    private static ApplicationContext applicationContext
    private static final JDBC_TEMPLATE = 'jdbcTemplate'
    private static final H2 = 'org.h2.Driver'

    void cleanupSpec() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, *tables)
        resetIdGeneration()
    }

    protected static JdbcTemplate getJdbcTemplate() {
        (JdbcTemplate) applicationContext.getBean(JDBC_TEMPLATE)
    }

    protected void resetIdGeneration() {
        tables.each { String table -> jdbcTemplate.execute(queryFor(table)) }
    }

    protected String queryFor(String table) {
        isH2() ? "alter table $table ALTER COLUMN id RESTART WITH 1" : "alter table $table AUTO_INCREMENT = 1"
    }

    @Cacheable
    protected boolean isH2() {
        jdbcTemplate.dataSource.properties.driverClassName == H2
    }

    @Override
    void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext
    }
}
