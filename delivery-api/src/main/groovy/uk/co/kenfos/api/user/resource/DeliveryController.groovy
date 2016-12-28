package uk.co.kenfos.api.user.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.co.kenfos.api.user.json.DeliveryJsonMapper
import uk.co.kenfos.api.user.repository.DeliveryRepository
import uk.co.kenfos.api.user.resource.rest.Resource

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestMapping(value = '/delivery', produces = 'application/json')
class DeliveryController implements Resource {

    @Autowired private DeliveryRepository deliveryRepository

    Class objectMapper = DeliveryJsonMapper

    @RequestMapping(method = GET, value = '/{id}')
    def find(@PathVariable Long id) {
        ok deliveryRepository.getOne(id)
    }

    @RequestMapping(method = GET, produces = 'application/json')
    def findAll() {
        ok deliveryRepository.findAll()
    }

}
