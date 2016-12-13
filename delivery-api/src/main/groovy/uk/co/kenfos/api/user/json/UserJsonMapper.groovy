package uk.co.kenfos.api.user.json

import com.fasterxml.jackson.databind.ObjectMapper
import uk.co.kenfos.api.user.json.mixins.DeliveryMixin
import uk.co.kenfos.api.user.json.mixins.UserMixin
import uk.co.kenfos.api.user.model.User
import uk.co.kenfos.api.user.model.delivery.Delivery

class UserJsonMapper extends ObjectMapper {

    UserJsonMapper() {
        this.addMixIn(User, UserMixin)
        this.addMixIn(Delivery, DeliveryMixin)
    }
}
