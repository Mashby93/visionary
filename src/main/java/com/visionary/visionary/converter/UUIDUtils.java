package com.visionary.visionary.converter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UUIDUtils {
    private static final UUIDConverter converter = new UUIDConverter();

    public static String convertToDatabase(UUID id) {
        return converter.convertToDatabaseColumn(id);
    }

    public static List<String> convertToDatabase(List<UUID> ids) {
        return ids.stream().map(id -> convertToDatabase(id)).collect(Collectors.toList());
    }

}
