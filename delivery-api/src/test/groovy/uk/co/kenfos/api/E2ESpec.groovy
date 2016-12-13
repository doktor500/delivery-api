package uk.co.kenfos.api

import com.jayway.restassured.specification.RequestSpecification
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Value

import static com.jayway.restassured.RestAssured.config
import static com.jayway.restassured.RestAssured.given
import static com.jayway.restassured.config.DecoderConfig.decoderConfig
import static com.jayway.restassured.config.EncoderConfig.encoderConfig
import static com.jayway.restassured.config.RestAssuredConfig.newConfig
import static com.jayway.restassured.http.ContentType.JSON

@SuppressWarnings('AbstractClassWithoutAbstractMethod')
abstract class E2ESpec extends ApiBaseIntegrationSpec {

    private static final CONTENT_CHARSET = 'UTF-8'

    @Value('${server.url}') private String serverURL
    @Value('${server.port}') private Integer serverPort

    protected jsonSlurper = new JsonSlurper()

    void setupSpec() {
        config = restConfig()
    }

    protected post(Map args) {
        requestTo(args.resource).body(args.content).post()
    }

    protected get(Map args) {
        requestTo("${args.resource}/${getResourceId(args)}").get()
    }

    protected get(Map args, Map queryParameters) {
        requestTo("${args.resource}/${getResourceId(args)}", queryParameters).get()
    }

    protected json(response) {
        response.jsonPath().get()
    }

    protected parse(String text) {
        jsonSlurper.parseText(text)
    }

    protected RequestSpecification requestTo(String path, Map queryParameters) {
        def request = requestTo(path)
        queryParameters.each { entry -> addParameters(request, entry) }
        request
    }

    protected RequestSpecification requestTo(String path) {
        given().accept(JSON).contentType(JSON).baseUri(serverURL).port(serverPort).basePath(path)
    }

    protected addParameters(request, entry) {
        entry.value.each { request.queryParam(entry.key, it) }
    }

    private static restConfig() {
        newConfig().encoderConfig(encoderConf()).decoderConfig(decoderConf())
    }

    private static encoderConf() {
        encoderConfig().defaultContentCharset(CONTENT_CHARSET)
    }

    private static decoderConf(){
        decoderConfig().defaultContentCharset(CONTENT_CHARSET)
    }
}
