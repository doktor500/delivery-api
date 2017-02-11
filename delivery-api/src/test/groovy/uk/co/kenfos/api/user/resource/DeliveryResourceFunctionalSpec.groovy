package uk.co.kenfos.api.user.resource

import org.junit.Rule
import software.betamax.junit.Betamax
import spock.lang.Stepwise
import uk.co.kenfos.api.ApiFunctionalSpec
import uk.co.kenfos.api.BetamaxRecorderRule

import static java.net.HttpURLConnection.HTTP_CREATED
import static java.net.HttpURLConnection.HTTP_OK
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath as field
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import static org.unitils.reflectionassert.ReflectionAssert.assertLenientEquals
import static uk.co.kenfos.api.user.model.delivery.Delivery.DEFAULT_PRIORITY

@Stepwise
class DeliveryResourceFunctionalSpec extends ApiFunctionalSpec implements UserResource, DeliveryResource {

    private static final USER_RESOURCE = '/user'
    private static final DELIVERY_RESOURCE = '/delivery'

    @Rule BetamaxRecorderRule betamaxRecorderRule = new BetamaxRecorderRule()

    @Betamax(tape = 'get-user-billing-agreement-state')
    void 'creates a new user'() {
        when:
        def response = post(resource: USER_RESOURCE, content: aUser())

        then:
        response.statusCode == HTTP_CREATED
    }

    void 'GET /delivery/{id} successfully'() {
        when:
        def response = get(
            id: 1,
            resource: DELIVERY_RESOURCE,
            document: document('get-delivery', preprocessResponse(prettyPrint()), response())
        )

        then:
        response.statusCode == HTTP_OK
        assertLenientEquals(json(response), parse(delivery(DEFAULT_PRIORITY)))
    }

    void 'GET /delivery successfully'() {
        when:
        def response = get(
            resource: DELIVERY_RESOURCE,
            document: document('get-deliveries', preprocessResponse(prettyPrint()), response(asList: true))
        )

        then:
        response.statusCode == HTTP_OK
        assertLenientEquals(json(response), parse(deliveries(DEFAULT_PRIORITY)))
    }

    private response(args = [:]) {
        def prefix = args.asList ? '[].' : ''
        responseFields(
            field("${prefix}id").description('Delivery Id'),
            field("${prefix}priority").description('Delivery priority')
        )
    }
}
