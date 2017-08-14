package uk.co.kenfos.api.user.resource

import org.junit.Rule
import software.betamax.junit.Betamax
import spock.lang.Stepwise
import uk.co.kenfos.api.ApiFunctionalSpec
import uk.co.kenfos.api.BetamaxRecorderRule

import static java.net.HttpURLConnection.HTTP_CREATED
import static java.net.HttpURLConnection.HTTP_OK
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath as field
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import static org.unitils.reflectionassert.ReflectionAssert.assertLenientEquals
import static uk.co.kenfos.api.DateTimeUtils.isCurrentDay
import static uk.co.kenfos.api.user.model.delivery.Delivery.DEFAULT_PRIORITY

@Stepwise
@SuppressWarnings('DuplicateStringLiteral')
class UserResourceFunctionalSpec extends ApiFunctionalSpec implements UserResource {

    private static final USER_RESOURCE = '/user'

    @Rule BetamaxRecorderRule recorderRule = new BetamaxRecorderRule()

    @Betamax(tape = 'get-user-billing-agreement-state')
    void 'POST /user successfully'() {
        when:
        def response = post(
            resource: USER_RESOURCE,
            content:  aUser(),
            document: document(
                'post-user',
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                request(),
                response()
            )
        )

        then:
        response.statusCode == HTTP_CREATED
    }

    @Betamax(tape = 'get-user-billing-agreement-state')
    void 'GET /user/{id} successfully'() {
        when:
        def response = get(
            id: 1,
            resource: USER_RESOURCE,
            document: document('get-user', preprocessResponse(prettyPrint()), response())
        )

        then:
        def dateCreated = json(response).dateCreated
        def priority = json(response).deliveries.first().priority
        response.statusCode == HTTP_OK
        assertLenientEquals(json(response), parse(user(dateCreated, priority)))
    }

    @Betamax(tape = 'get-user-billing-agreement-state')
    void 'GET /user successfully'() {
        when:
        def response = get(
            resource: USER_RESOURCE,
            document: document('get-users', preprocessResponse(prettyPrint()), response(asList: true))
        )
        def dateCreated = json(response).first().dateCreated

        then:
        response.statusCode == HTTP_OK
        assertLenientEquals(json(response), parse(users(dateCreated, DEFAULT_PRIORITY)))

        and:
        isCurrentDay(dateCreated)
    }

    private request() {
        requestFields(
            field('phoneNumber').description('User phone number'),
            field('postcode').description('User postcode')
        )
    }

    private response(args = [:]) {
        def prefix = args.asList ? '[].' : ''
        responseFields(
            field("${prefix}id").description('User id'),
            field("${prefix}billingAgreementStatus").description('User billing agreement status'),
            field("${prefix}contactDetails.phoneNumber").description('User phone number'),
            field("${prefix}contactDetails.postcode").description('User postcode'),
            field("${prefix}dateCreated").description('Date when user has been created'),
            field("${prefix}lang").description('Language'),
            field("${prefix}deliveries").description('List of deliveries'),
            field("${prefix}deliveries[].id").description('Delivery id')
        )
    }
}
