package uk.co.kenfos.api.fixtures.user

import uk.co.kenfos.api.fixtures.delivery.DeliveryFixture
import uk.co.kenfos.api.user.model.User
import uk.co.kenfos.api.user.model.delivery.Delivery

class UserFixture {

    static User validSample(args = [:]) {
        def user = new User()
        user.contactDetails = ContactDetailsFixture.validSample()
        user.deliveries = args.deliveries != null ? deliveries(user, args.deliveries) : [validDelivery(user: user)]
        user
    }

    private static deliveries(User user, List<Delivery> deliveries) {
        deliveries.each { it.user = user }
        deliveries
    }

    private static validDelivery(args) {
        DeliveryFixture.validSample(user: args.user)
    }
}
