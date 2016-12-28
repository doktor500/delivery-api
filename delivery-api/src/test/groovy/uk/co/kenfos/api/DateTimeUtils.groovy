package uk.co.kenfos.api

import java.time.LocalDateTime

import static java.time.temporal.ChronoUnit.DAYS
import static org.junit.Assert.assertEquals

@SuppressWarnings('SpecFileName')
class DateTimeUtils {

    static void isCurrentDay(String date) {
        assertEquals(LocalDateTime.parse(date).truncatedTo(DAYS), LocalDateTime.now().truncatedTo(DAYS))
    }
}
