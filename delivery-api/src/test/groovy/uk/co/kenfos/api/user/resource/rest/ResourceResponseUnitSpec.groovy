package uk.co.kenfos.api.user.resource.rest

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

import static java.util.Calendar.JANUARY

class ResourceResponseUnitSpec extends Specification {

    void 'dates are returned as timestamps'() {
        given:
        def defaultTimeZone = TimeZone.default
        TimeZone.default = TimeZone.getTimeZone('UTC')

        and:
        def resource = new TestResource()
        def entity = new GregorianCalendar(2015, JANUARY, 1).time

        expect:
        resource.action(entity).body == '"2015-01-01T00:00:00.000+0000"'

        cleanup:
        TimeZone.default = defaultTimeZone
    }

    private class TestResource implements Resource {

        Class objectMapper = ObjectMapper

        def action(entity) {
            created entity
        }
    }
}
