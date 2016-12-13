package uk.co.kenfos.api.user.model

import groovy.transform.InheritConstructors
import org.hibernate.validator.constraints.NotBlank

import javax.persistence.Embeddable
import javax.validation.constraints.NotNull

@Embeddable
@InheritConstructors
class ContactDetails {

    @NotBlank(message = 'user.phoneNumber.blank')
    @NotNull(message = 'user.phoneNumber.null')
    String phoneNumber

    @NotBlank(message = 'user.postcode.blank')
    @NotNull(message = 'user.postcode.null')
    String postcode

}
