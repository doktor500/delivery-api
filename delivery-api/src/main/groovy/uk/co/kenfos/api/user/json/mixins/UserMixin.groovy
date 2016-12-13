package uk.co.kenfos.api.user.json.mixins

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@SuppressWarnings('AbstractClassWithoutAbstractMethod')
@JsonIgnoreProperties(['hibernateLazyInitializer', 'handler'])
abstract class UserMixin { }
