package uk.co.kenfos.api.user.json.mixins

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.joda.time.DateTime
import uk.co.kenfos.api.user.model.User

@SuppressWarnings('AbstractClassWithoutAbstractMethod')
@JsonIgnoreProperties(['hibernateLazyInitializer', 'handler'])
abstract class DeliveryMixin {
    @JsonIgnore User user
    @JsonIgnore DateTime getDateCreated() {}
}
