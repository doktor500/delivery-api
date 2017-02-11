package uk.co.kenfos.api.user.resource.rest

import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import uk.co.kenfos.api.common.validation.InvalidEntityException

import javax.persistence.EntityNotFoundException

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import static com.fasterxml.jackson.databind.SerializationFeature.*
import static org.springframework.http.HttpStatus.*

trait Resource<TYPE extends ObjectMapper> {

    def created(entity) {
        new ResponseEntity(serialize(entity), CREATED)
    }

    def ok(entity) {
        try {
            serialize(entity)
        } catch (JsonMappingException exception) {
            handleException(exception.cause)
        }
    }

    def serialize(entity) {
        def mapper = this.class.genericInfo.superInterfaces.first().actualTypeArguments.first()
        createObjectMapper(mapper).writeValueAsString(entity)
    }

    @Cacheable
    TYPE createObjectMapper(mapper) {
        ObjectMapper objectMapper = mapper.newInstance()
        objectMapper.with {
            findAndRegisterModules()
            registerModule(new SimpleModule())
            configure(WRITE_DATES_AS_TIMESTAMPS, false)
            configure(FAIL_ON_EMPTY_BEANS, false)
            setSerializationInclusion(NON_NULL)
        }
        objectMapper
    }

    @ExceptionHandler(EntityNotFoundException)
    ResponseEntity handleException(EntityNotFoundException exception) {
        new ResponseEntity(exception.message, NOT_FOUND)
    }

    @ExceptionHandler(InvalidEntityException)
    ResponseEntity handleException(InvalidEntityException exception) {
        new ResponseEntity([errors: exception.errorMessages], BAD_REQUEST)
    }

}
