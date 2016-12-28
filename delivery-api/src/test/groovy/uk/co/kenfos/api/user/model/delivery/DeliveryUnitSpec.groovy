package uk.co.kenfos.api.user.model.delivery

import spock.lang.Specification

import java.time.LocalDateTime

import static java.time.temporal.ChronoUnit.SECONDS

class DeliveryUnitSpec extends Specification {

    void 'delivery is created with current date'() {
        given:
        def currentDate = LocalDateTime.now()

        when:
        def delivery = new Delivery()

        then:
        delivery.dateCreated.truncatedTo(SECONDS) == currentDate.truncatedTo(SECONDS)
    }
}
