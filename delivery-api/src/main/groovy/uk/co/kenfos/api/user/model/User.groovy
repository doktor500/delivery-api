package uk.co.kenfos.api.user.model

import groovy.transform.InheritConstructors
import org.joda.time.DateTime
import uk.co.kenfos.api.user.model.delivery.Delivery

import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

import static javax.persistence.CascadeType.ALL

@Entity
@InheritConstructors
class User {

    @Id
    @GeneratedValue
    Long id

    @Valid
    @Embedded
    @NotNull(message = 'user.contactDetails.null')
    ContactDetails contactDetails

    @Valid
    @OneToMany(mappedBy = 'user', cascade = ALL)
    @Size(min = 0, message = 'user.deliveries.minSize')
    @NotNull(message = 'user.deliveries.null')
    Set<Delivery> deliveries = []

    @Column(updatable = false)
    final DateTime dateCreated = DateTime.now()

    @Transient
    String billingAgreementStatus
}
