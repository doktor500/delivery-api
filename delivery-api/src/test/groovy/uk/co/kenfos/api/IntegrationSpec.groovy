package uk.co.kenfos.api

import org.springframework.boot.test.SpringApplicationConfiguration
import spock.lang.Specification

@SpringApplicationConfiguration(classes = Application)
@SuppressWarnings('AbstractClassWithoutAbstractMethod')
abstract class IntegrationSpec extends Specification {

}
