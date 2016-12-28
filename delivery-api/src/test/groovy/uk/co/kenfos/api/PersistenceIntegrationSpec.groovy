package uk.co.kenfos.api

import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional

@Transactional
@Rollback(true)
@ActiveProfiles('test-default')
@SuppressWarnings('AbstractClassWithoutAbstractMethod')
abstract class PersistenceIntegrationSpec extends PersistenceAwareIntegrationSpec {

}
