package com.visionary.visionary.util;

public class ValidationUtil {
    private static void assertTrue(Boolean status, RuntimeException instance) {
        if (!status) {
            throw instance;
        }
    }

    public static void assertNoVulgarity(String text) {
        assertTrue(noVulgarity(text), new IllegalArgumentException());
    }

    public static void assertValidEmail(String email) {
        assertTrue(validEmail(email), new IllegalArgumentException());
    }

    public static boolean noVulgarity(String text) {
        return true;
    }
    public static boolean validEmail(String email) {return true;}
}
