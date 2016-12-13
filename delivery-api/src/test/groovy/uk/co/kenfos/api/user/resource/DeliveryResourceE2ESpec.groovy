package uk.co.kenfos.api.user.resource

import uk.co.kenfos.api.E2ESpec

import static java.net.HttpURLConnection.HTTP_NOT_FOUND

class DeliveryResourceE2ESpec extends E2ESpec {

    private static final DELIVERY_RESOURCE = '/delivery'

    void 'returns not found when searching for a non existing delivery'() {
        when:
        def response = get(resource: DELIVERY_RESOURCE, id: 1)

        then:
        response.statusCode == HTTP_NOT_FOUND
    }

}
