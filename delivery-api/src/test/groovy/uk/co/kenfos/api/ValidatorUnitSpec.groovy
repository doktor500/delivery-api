package uk.co.kenfos.api

import spock.lang.Specification
import uk.co.kenfos.api.common.validation.EntityValidator
import uk.co.kenfos.api.common.validation.InvalidEntityException

@SuppressWarnings('AbstractClassWithoutAbstractMethod')
abstract class ValidatorUnitSpec extends Specification {

    protected EntityValidator validator

    void setup() {
        this.validator = new EntityValidator()
    }

    protected boolean valid(entity) {
        validator.validate(entity)
        true
    }

    protected boolean invalid(entity, errorMessage) {
        try {
            validator.validate(entity)
        } catch (InvalidEntityException exception) {
            assert errorMessage.toString() in exception.errorMessages
            true
        }
    }

    protected boolean invalid(entity) {
        try {
            validator.validate(entity)
        } catch (InvalidEntityException exception) {
            true
        }
    }

}
