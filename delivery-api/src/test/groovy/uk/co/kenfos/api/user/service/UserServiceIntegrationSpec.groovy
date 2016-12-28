package uk.co.kenfos.api.user.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles
import uk.co.kenfos.api.PersistenceIntegrationSpec
import uk.co.kenfos.api.fixtures.user.UserFixture

@ActiveProfiles('fake-payment-service')
class UserServiceIntegrationSpec extends PersistenceIntegrationSpec {

    private static final BILLING_AGREEMENT_STATE = 'Active'

    @Autowired private UserService userService

    void 'returns user with billing agreement state when a user is saved to the db'() {
        when:
        def user = userService.save(UserFixture.validSample())

        then:
        user.billingAgreementStatus == BILLING_AGREEMENT_STATE
    }

    void 'returns user with billing agreement state when a user is fetched from the db'() {
        given:
        def savedUser = userService.save(UserFixture.validSample())

        when:
        def user = userService.getOne(savedUser.id)

        then:
        user.billingAgreementStatus == BILLING_AGREEMENT_STATE
    }

    void 'returns users with billing agreement state when a list of user is fetched from the db'() {
        given:
        userService.save(UserFixture.validSample())

        when:
        def users = userService.findAll()

        then:
        users && users.every { user -> user.billingAgreementStatus == BILLING_AGREEMENT_STATE }
    }

}
