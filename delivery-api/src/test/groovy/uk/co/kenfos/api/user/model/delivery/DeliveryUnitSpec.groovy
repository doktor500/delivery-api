package uk.co.kenfos.api.user.model.delivery

import org.joda.time.DateTime
import org.joda.time.DateTimeUtils
import spock.lang.Specification

class DeliveryUnitSpec extends Specification {

    void 'delivery is created with current date'() {
        given:
        def currentDate = DateTime.now()
        DateTimeUtils.currentMillisFixed = currentDate.millis

        when:
        def delivery = new Delivery()

        then:
        delivery.dateCreated == currentDate

        cleanup:
        DateTimeUtils.setCurrentMillisSystem()
    }
}
