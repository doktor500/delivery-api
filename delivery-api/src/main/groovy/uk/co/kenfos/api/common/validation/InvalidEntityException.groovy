package uk.co.kenfos.api.common.validation

import javax.validation.ConstraintViolation

class InvalidEntityException extends RuntimeException {

    private static final NEW_LINE = '\n'

    Set<String> errorMessages = []

    InvalidEntityException(Set<ConstraintViolation> errors) {
        super(errors*.message.join(NEW_LINE))
        errorMessages = errors*.message
    }

}
