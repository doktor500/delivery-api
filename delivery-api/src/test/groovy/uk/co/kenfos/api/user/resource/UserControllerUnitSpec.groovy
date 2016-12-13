package uk.co.kenfos.api.user.resource

import spock.lang.Specification
import spock.lang.Subject
import uk.co.kenfos.api.common.validation.EntityValidator
import uk.co.kenfos.api.user.model.User
import uk.co.kenfos.api.user.resource.command.CreateUserCommand
import uk.co.kenfos.api.user.service.UserService

class UserControllerUnitSpec extends Specification {

    @Subject UserController userController
    UserService userService
    EntityValidator entityValidator

    void setup() {
        userService = Mock()
        entityValidator = Mock()
        userController = new UserController(userService: userService, entityValidator: entityValidator)
    }

    void 'calls user repository to save a valid user'() {
        given:
        def user = new User()
        def cmd = Stub(CreateUserCommand)
        cmd.execute() >> user

        when:
        userController.create(cmd)

        then:
        1 * entityValidator.validate(user)
        1 * userService.save(user)
    }

    void 'calls user repository to find a user by id'() {
        given:
        def userId = 1

        when:
        userController.find(userId)

        then:
        1 * userService.getOne(userId)
    }

    void 'calls user repository to get a list of users'() {
        when:
        userController.findAll()

        then:
        1 * userService.findAll()
    }
}
