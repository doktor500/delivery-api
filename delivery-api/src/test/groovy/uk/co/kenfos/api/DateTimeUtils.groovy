package uk.co.kenfos.api

import org.joda.time.DateTime

import static java.util.concurrent.TimeUnit.DAYS
import static java.util.concurrent.TimeUnit.SECONDS
import static org.junit.Assert.assertThat
import static uk.co.it.modular.hamcrest.date.DateMatchers.within

@SuppressWarnings('SpecFileName')
class DateTimeUtils {

    static void isCurrentDate(String date) {
        assertThat(DateTime.parse(date).toDate(), within(3, SECONDS, new Date()))
    }

    static void isCurrentDay(String date) {
        assertThat(DateTime.parse(date).toDate(), within(1, DAYS, new Date()))
    }
}
