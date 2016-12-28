package uk.co.kenfos.api.utils

import java.time.Clock as SystemClock
import java.time.LocalDateTime

class Clock {

    protected static SystemClock clock = SystemClock.systemDefaultZone()

    static LocalDateTime now() {
        LocalDateTime.now(clock)
    }

}
