package uk.co.kenfos.api.user.json

import com.fasterxml.jackson.databind.ObjectMapper
import uk.co.kenfos.api.user.json.mixins.DeliveryMixin
import uk.co.kenfos.api.user.json.mixins.UserWithoutDeliveriesMixin
import uk.co.kenfos.api.user.model.User
import uk.co.kenfos.api.user.model.delivery.Delivery

class DeliveryJsonMapper extends ObjectMapper {

    DeliveryJsonMapper() {
        this.addMixIn(Delivery, DeliveryMixin)
        this.addMixIn(User, UserWithoutDeliveriesMixin)
    }
}
