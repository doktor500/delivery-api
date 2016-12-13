package uk.co.kenfos.api.user.resource

import org.springframework.beans.factory.annotation.Autowired
import uk.co.kenfos.api.PersistenceIntegrationSpec
import uk.co.kenfos.api.fixtures.user.UserFixture
import uk.co.kenfos.api.user.repository.UserRepository

class UserRepositoryIntegrationSpec extends PersistenceIntegrationSpec {

    private static final DEFAULT_PRIORITY = 100

    @Autowired UserRepository userRepository

    void 'a user is created with a delivery'() {
        when:
        def user = userRepository.save(UserFixture.validSample())

        then:
        user.deliveries*.priority == [DEFAULT_PRIORITY]
    }
}
