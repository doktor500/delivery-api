package uk.co.kenfos.api.user.json.mixins

import com.fasterxml.jackson.annotation.JsonIgnore
import uk.co.kenfos.api.user.model.ContactDetails
import uk.co.kenfos.api.user.model.delivery.Delivery

import java.time.LocalDateTime

@SuppressWarnings('AbstractClassWithoutAbstractMethod')
abstract class UserWithoutDeliveriesMixin {
    @JsonIgnore ContactDetails contactDetails
    @JsonIgnore LocalDateTime dateCreated
    @JsonIgnore Set<Delivery> deliveries
}
