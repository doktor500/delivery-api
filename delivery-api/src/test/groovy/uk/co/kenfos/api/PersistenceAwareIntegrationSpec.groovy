package uk.co.kenfos.api

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.jdbc.JdbcTestUtils

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT
import static uk.co.kenfos.api.Database.tables

@SpringBootTest(webEnvironment = DEFINED_PORT)
@SuppressWarnings('AbstractClassWithoutAbstractMethod')
abstract class PersistenceAwareIntegrationSpec extends IntegrationSpec implements ApplicationContextAware {

    private static ApplicationContext applicationContext
    private static final JDBC_TEMPLATE = 'jdbcTemplate'

    void cleanupSpec() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, *tables)
        resetIdGeneration()
    }

    protected static JdbcTemplate getJdbcTemplate() {
        (JdbcTemplate) applicationContext.getBean(JDBC_TEMPLATE)
    }

    protected void resetIdGeneration() {
        tables.each { jdbcTemplate.execute("alter table $it AUTO_INCREMENT = 1") }
    }

    @Override
    void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext
    }
}
