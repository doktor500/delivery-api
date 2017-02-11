package uk.co.kenfos.api.user.model.delivery

import groovy.transform.InheritConstructors
import uk.co.kenfos.api.utils.Clock
import uk.co.kenfos.api.user.model.User

import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import java.time.LocalDateTime

@Entity
@InheritConstructors
class Delivery {

    static final DEFAULT_PRIORITY = 1

    @Id
    @GeneratedValue
    Long id

    @Valid
    @ManyToOne
    @NotNull(message = 'delivery.user.null')
    User user

    @Column(updatable = false)
    @SuppressWarnings('PrivateFieldCouldBeFinal')
    private LocalDateTime dateCreated = Clock.now()

    @NotNull(message = 'delivery.priority.null')
    @Min(value = 0L, message = 'delivery.priority.min')
    Integer priority = DEFAULT_PRIORITY

    Delivery(Map args) {
        this.id = args.id
        this.user = args.user
        this.dateCreated = args.dateCreated ?: Clock.now()
        this.priority = args.priority ?: DEFAULT_PRIORITY
    }

    LocalDateTime getDateCreated() {
        dateCreated
    }
}
