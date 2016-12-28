package uk.co.kenfos.api.config

import javax.persistence.AttributeConverter
import javax.persistence.Converter
import java.sql.Timestamp
import java.time.LocalDateTime

@Converter(autoApply = true)
class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        localDateTime ? Timestamp.valueOf(localDateTime) : null
    }

    @Override
    LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        sqlTimestamp ? sqlTimestamp.toLocalDateTime() : null
    }
}
