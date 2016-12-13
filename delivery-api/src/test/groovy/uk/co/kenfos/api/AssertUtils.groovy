package uk.co.kenfos.api

import org.unitils.reflectionassert.ReflectionAssert

@SuppressWarnings('SpecFileName')
class AssertUtils {

    static boolean reflectionEquals(current, expected) {
        ReflectionAssert.assertReflectionEquals(expected, current)
        true
    }
}
