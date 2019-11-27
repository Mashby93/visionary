package com.visionary.visionary.util;

import java.util.Objects;

public class ValidationUtil {
    public static void assertTrue(Boolean status, RuntimeException instance) {
        if (!status) {
            throw instance;
        }
    }

    public static void assertFalse(Boolean status, RuntimeException instance) {
        if (status) {
            throw instance;
        }
    }

    public static void assertEquals(Object lhs, Object rhs, RuntimeException exception) {
        assertTrue(lhs.equals(rhs), exception);
    }

    public static void assertNoVulgarity(String text) {
        assertTrue(noVulgarity(text), new IllegalArgumentException());
    }

    public static void assertValidEmail(String email) {
        assertTrue(validEmail(email), new IllegalArgumentException());
    }

    public static void assertNotNull(Object obj, RuntimeException exception) {
        assertTrue(Objects.nonNull(obj), exception);
    }

    public static boolean noVulgarity(String text) {
        return true;
    }

    public static boolean validEmail(String email) {
        if (!email.contains("@")) {
            return false;
        }
        return true;
    }

}
