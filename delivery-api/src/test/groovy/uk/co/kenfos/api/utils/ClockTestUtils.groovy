package uk.co.kenfos.api.utils

import java.time.LocalDateTime
import java.time.ZoneId

@SuppressWarnings('SpecFileName')
class ClockTestUtils extends Clock {

    private static final ZoneId ZONE_ID = ZoneId.systemDefault()

    static void fixClock(LocalDateTime date = LocalDateTime.now()) {
        clock = java.time.Clock.fixed(date.atZone(ZONE_ID).toInstant(), ZONE_ID)
    }

    static void useSystemDefaultClock() {
        clock = java.time.Clock.systemDefaultZone()
    }
}
