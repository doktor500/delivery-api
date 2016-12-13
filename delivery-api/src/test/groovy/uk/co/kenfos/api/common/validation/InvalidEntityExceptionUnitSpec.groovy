package uk.co.kenfos.api.common.validation

import spock.lang.Specification

import javax.validation.ConstraintViolation

import static org.apache.commons.lang.StringUtils.EMPTY

class InvalidEntityExceptionUnitSpec extends Specification {

    void 'sets error messages'() {
        given:
        def errorMessage = 'error'
        def errors = [new ConstraintError(errorMessage)] as Set
        def exception = new InvalidEntityException(errors)

        expect:
        exception.errorMessages == [errorMessage] as Set
    }

    private class ConstraintError implements ConstraintViolation {

        @Delegate ConstraintViolation constraintViolation

        String errorMessage = EMPTY

        ConstraintError(errorMessage) {
            this.errorMessage = errorMessage
        }

        String getMessage() {
            errorMessage
        }
    }
}
