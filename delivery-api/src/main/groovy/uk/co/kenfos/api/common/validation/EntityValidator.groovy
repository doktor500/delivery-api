package uk.co.kenfos.api.common.validation

import org.springframework.stereotype.Component

import javax.validation.Validation
import javax.validation.Validator

@Component
class EntityValidator {

    private final Validator validator = validatorFactory.validator

    void validate(entity) {
        def errors = validator.validate(entity)
        if (errors) {
            throw new InvalidEntityException(errors)
        }
    }

    private getValidatorFactory() {
        Validation.buildDefaultValidatorFactory()
    }
}
