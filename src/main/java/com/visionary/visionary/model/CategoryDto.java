package com.visionary.visionary.model;

import java.util.UUID;

public class CategoryDto {
    private UUID id;
    private String display;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
