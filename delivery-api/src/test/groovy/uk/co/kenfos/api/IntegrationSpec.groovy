package uk.co.kenfos.api

import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = Application)
@SuppressWarnings('AbstractClassWithoutAbstractMethod')
abstract class IntegrationSpec extends Specification {

}
