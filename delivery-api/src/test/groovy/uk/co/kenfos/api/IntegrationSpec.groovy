package uk.co.kenfos.api

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@ContextConfiguration(classes = Application)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@SuppressWarnings('AbstractClassWithoutAbstractMethod')
abstract class IntegrationSpec extends Specification {

}
