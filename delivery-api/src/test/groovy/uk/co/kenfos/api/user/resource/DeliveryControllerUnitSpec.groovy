package uk.co.kenfos.api.user.resource

import spock.lang.Specification
import spock.lang.Subject
import uk.co.kenfos.api.user.repository.DeliveryRepository

class DeliveryControllerUnitSpec extends Specification {

    @Subject DeliveryController deliveryController
    DeliveryRepository deliveryRepository

    void setup() {
        deliveryRepository = Mock()
        deliveryController = new DeliveryController(deliveryRepository: deliveryRepository)
    }

    void 'calls delivery repository to get a delivery'() {
        given:
        def id = 1L

        when:
        deliveryController.find(id)

        then:
        1 * deliveryRepository.getOne(id)
    }

    void 'calls delivery repository to get a list of deliveries'() {
        when:
        deliveryController.findAll()

        then:
        1 * deliveryRepository.findAll()
    }
}
