package uk.co.kenfos.api.user.resource

import uk.co.kenfos.api.E2ESpec

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST
import static org.apache.commons.lang.StringUtils.EMPTY

class UserResourceE2ESpec extends E2ESpec implements UserResource {

    private static final USER_RESOURCE = '/user'

    void 'does not create a new user when it is invalid'() {
        given:
        def invalidUser = aUser(phoneNumber: EMPTY, postcode: EMPTY)

        when:
        def response = post(resource: USER_RESOURCE, content: invalidUser)

        then:
        response.statusCode == HTTP_BAD_REQUEST
    }
}
