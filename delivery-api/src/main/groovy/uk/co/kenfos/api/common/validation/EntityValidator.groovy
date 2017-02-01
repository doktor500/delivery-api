package uk.co.kenfos.api.common.validation

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

import javax.validation.Validation
import javax.validation.Validator

@Slf4j
@Component
class EntityValidator {

    private final Validator validator = validatorFactory.validator

    void validate(entity) {
        def errors = validator.validate(entity)
        if (errors) {
            log.warn("validation errors: $errors")
            throw new InvalidEntityException(errors)
        }
    }

    private getValidatorFactory() {
        Validation.buildDefaultValidatorFactory()
    }
}
