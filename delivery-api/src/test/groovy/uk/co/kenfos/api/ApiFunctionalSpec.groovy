package uk.co.kenfos.api

import groovy.json.JsonSlurper
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.restdocs.JUnitRestDocumentation
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext

import static org.apache.commons.lang.StringUtils.EMPTY
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@SuppressWarnings(['AbstractClassWithoutAbstractMethod', 'UnusedMethodParameter'])
abstract class ApiFunctionalSpec extends ApiBaseIntegrationSpec {

    @Rule JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation('build/generated-snippets')
    @Autowired WebApplicationContext context

    protected JsonSlurper jsonSlurper = new JsonSlurper()
    protected MockMvc mockMvc

    void setup() {
        mockMvc = webAppContextSetup(context).apply(documentationConfiguration(restDocumentation)).build()
    }

    protected post(Map args) {
        executeRequest(args, 'POST')
    }

    protected get(Map args, Map queryParameters = [:]) {
        executeRequest(args, 'GET', queryParameters)
    }

    protected executeRequest(Map args, String type, Map queryParameters = [:]) {
        def action = type.toLowerCase().capitalize()
        def response = mockMvc.perform("do${action}"(args, queryParameters))
            .andDo(args.document ?: log())
            .andReturn()
            .response
        [content: response.contentAsString, statusCode: response.status]
    }

    protected doPost(Map args, Map queryParameters) {
        post(args.resource).contentType('application/json').content(args.content)
    }

    protected doGet(Map args, Map queryParameters) {
        def params = queryParameters ? '?' + queryParameters.collect { "${it.key}=${it.value}" }.join('&') : EMPTY
        get("${args.resource}/{id}${params}", getResourceId(args))
    }

    protected json(response) {
        parse(response.content)
    }

    protected parse(String text) {
        jsonSlurper.parseText(text)
    }
}
