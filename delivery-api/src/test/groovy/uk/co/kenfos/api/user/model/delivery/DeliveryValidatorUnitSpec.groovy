package uk.co.kenfos.api.user.model.delivery

import spock.lang.Unroll
import uk.co.kenfos.api.ValidatorUnitSpec
import uk.co.kenfos.api.user.model.User
import uk.co.kenfos.api.fixtures.delivery.DeliveryFixture

@SuppressWarnings('DuplicateStringLiteral')
class DeliveryValidatorUnitSpec extends ValidatorUnitSpec {

    private Delivery delivery

    void setup() {
        delivery = DeliveryFixture.validSample()
    }

    void 'valid delivery should validate successfully'() {
        expect:
        valid delivery
    }

    @Unroll
    void "null required fields shouldn't validate"() {
        given:
        delivery."${field}" = null

        expect:
        invalid delivery, "delivery.${field}.null"

        where:
        field << ['user', 'priority']
    }

    @Unroll
    void "negative numeric values shouldn't validate"() {
        given:
        delivery."${field}" = -1

        expect:
        invalid delivery, "delivery.${field}.min"

        where:
        field << ['priority']
    }

    @Unroll
    void 'cascade validation is triggered'() {
        given:
        delivery."${field}" = entity

        expect:
        invalid delivery

        where:
        field  | entity
        'user' | new User()
    }
}
