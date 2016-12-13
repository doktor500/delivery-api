package uk.co.kenfos.api.user.model

import spock.lang.Unroll
import uk.co.kenfos.api.ValidatorUnitSpec
import uk.co.kenfos.api.fixtures.user.UserFixture
import uk.co.kenfos.api.user.model.delivery.Delivery

@SuppressWarnings('DuplicateStringLiteral')
class UserValidatorUnitSpec extends ValidatorUnitSpec {

    private User user

    void setup() {
        user = UserFixture.validSample()
    }

    void 'valid user should validate successfully'() {
        expect:
        valid user
    }

    @Unroll
    void "null required fields shouldn't validate"() {
        given:
        user."${field}" = null

        expect:
        invalid user, "user.${field}.null"

        where:
        field << ['contactDetails']
    }

    @Unroll
    void 'cascade validation is triggered'() {
        given:
        user."${field}" = entity

        expect:
        invalid user

        where:
        field        | entity
        'deliveries' | [new Delivery()]
    }
}
