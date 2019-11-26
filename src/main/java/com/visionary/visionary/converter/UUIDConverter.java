package com.visionary.visionary.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.UUID;

@Converter(autoApply = true)
public class UUIDConverter implements AttributeConverter<UUID, String> {

    public String convertToDatabaseColumn(UUID id) {
        return id.toString();
    }

    public UUID convertToEntityAttribute(String id) {
        return UUID.fromString(id);
    }
}
