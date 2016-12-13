package uk.co.kenfos.api.user.json.mixins

import com.fasterxml.jackson.annotation.JsonIgnore
import org.joda.time.DateTime
import uk.co.kenfos.api.user.model.ContactDetails
import uk.co.kenfos.api.user.model.delivery.Delivery

@SuppressWarnings('AbstractClassWithoutAbstractMethod')
abstract class UserWithoutDeliveriesMixin {
    @JsonIgnore ContactDetails contactDetails
    @JsonIgnore DateTime dateCreated
    @JsonIgnore Set<Delivery> deliveries
}
