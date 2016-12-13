package uk.co.kenfos.api.user.resource.command

import uk.co.kenfos.api.user.model.ContactDetails
import uk.co.kenfos.api.user.model.User
import uk.co.kenfos.api.user.model.delivery.Delivery

import static uk.co.kenfos.api.user.model.delivery.DeliveryType.FAST_DELIVERY

class CreateUserCommand {

    String phoneNumber
    String postcode

    User execute() {
        def contactDetails = new ContactDetails(phoneNumber: phoneNumber, postcode: postcode)
        def user = new User(contactDetails: contactDetails)
        user.deliveries = [new Delivery(user: user, type: FAST_DELIVERY)]
        user
    }

}
