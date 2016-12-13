package uk.co.kenfos.api.user.resource.command

import org.joda.time.DateTimeUtils
import spock.lang.Specification
import uk.co.kenfos.api.user.model.ContactDetails
import uk.co.kenfos.api.user.model.User
import uk.co.kenfos.api.user.model.delivery.Delivery

import static uk.co.kenfos.api.AssertUtils.reflectionEquals
import static uk.co.kenfos.api.user.model.delivery.DeliveryType.FAST_DELIVERY

class CreateUserCommandUnitSpec extends Specification {

    private static final PHONE_NUMBER = '0123456789'
    private static final POSTCODE = 'N1 AAA'

    void 'creates a user'() {
        given:
        DateTimeUtils.setCurrentMillisFixed(new Date().time)

        expect:
        reflectionEquals(userCmd.execute(), expectedUser)

        cleanup:
        DateTimeUtils.setCurrentMillisSystem()
    }

    private getUserCmd() {
        new CreateUserCommand(phoneNumber: PHONE_NUMBER, postcode: POSTCODE)
    }

    private getExpectedUser() {
        def contactDetails = new ContactDetails(phoneNumber: PHONE_NUMBER, postcode: POSTCODE)
        def user = new User(contactDetails: contactDetails)
        user.deliveries = [new Delivery(user: user, type: FAST_DELIVERY)]
        user
    }

}
