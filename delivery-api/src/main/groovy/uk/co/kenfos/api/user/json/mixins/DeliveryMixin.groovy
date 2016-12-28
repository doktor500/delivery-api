package uk.co.kenfos.api.user.json.mixins

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import uk.co.kenfos.api.user.model.User

import java.time.LocalDateTime

@SuppressWarnings('AbstractClassWithoutAbstractMethod')
@JsonIgnoreProperties(['hibernateLazyInitializer', 'handler'])
abstract class DeliveryMixin {
    @JsonIgnore User user
    @JsonIgnore LocalDateTime getDateCreated() {}
}
