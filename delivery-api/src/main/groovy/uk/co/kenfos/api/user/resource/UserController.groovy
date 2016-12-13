package uk.co.kenfos.api.user.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.co.kenfos.api.common.validation.EntityValidator
import uk.co.kenfos.api.user.json.UserJsonMapper
import uk.co.kenfos.api.user.resource.command.CreateUserCommand
import uk.co.kenfos.api.user.resource.rest.Resource
import uk.co.kenfos.api.user.service.UserService

import static javax.ws.rs.core.MediaType.APPLICATION_JSON
import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestMapping(value = '/user', produces = APPLICATION_JSON)
class UserController implements Resource {

    @Autowired private UserService userService
    @Autowired private EntityValidator entityValidator

    Class objectMapper = UserJsonMapper

    @RequestMapping(method = POST)
    def create(@RequestBody CreateUserCommand cmd) {
        def user = cmd.execute()
        entityValidator.validate(user)
        created userService.save(user)
    }

    @RequestMapping(method = GET, value = '/{id}')
    def find(@PathVariable Long id) {
        ok userService.getOne(id)
    }

    @RequestMapping(method = GET)
    def findAll() {
        ok userService.findAll()
    }
}
