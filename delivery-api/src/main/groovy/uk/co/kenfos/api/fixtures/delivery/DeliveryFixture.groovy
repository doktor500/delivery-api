package uk.co.kenfos.api.fixtures.delivery

import uk.co.kenfos.api.fixtures.user.UserFixture
import uk.co.kenfos.api.user.model.delivery.Delivery

class DeliveryFixture {

    static Delivery validSample(args = [:]) {
        new Delivery(
            priority: args.priority ?: 100,
            user: args.user ?: UserFixture.validSample()
        )
    }

}
