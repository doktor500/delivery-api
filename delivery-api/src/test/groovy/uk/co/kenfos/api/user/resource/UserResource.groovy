package uk.co.kenfos.api.user.resource

import static org.apache.commons.lang.StringUtils.EMPTY

@SuppressWarnings(['DuplicateStringLiteral', 'SpecFileName'])
trait UserResource implements FixtureTemplate {

    private static final PHONE_NUMBER = '0123456789'
    private static final POSTCODE = 'N1 AAA'

    def aUser(Map args = [:]) {
        getFixture(
            'UserRequest.fixture',
            [
                phoneNumber: args.phoneNumber == EMPTY ? args.phoneNumber : PHONE_NUMBER,
                postcode: args.postcode == EMPTY ? args.postcode : POSTCODE
            ]
        )
    }

    def users(dateCreated, priority) {
        "[ ${user(dateCreated, priority)} ]"
    }

    def user(dateCreated, priority) {
        getFixture(
            'UserResponse.fixture',
            [phoneNumber: PHONE_NUMBER, postcode: POSTCODE, dateCreated: dateCreated, priority: priority]
        )
    }
}
