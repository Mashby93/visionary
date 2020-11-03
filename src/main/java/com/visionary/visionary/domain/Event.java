package com.visionary.visionary.domain;

import com.visionary.visionary.model.DateRange;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "event")
public class Event extends AbstractEntity {
    private List<DateRange> dates;
    private String description;

    public List<DateRange> getDates() {
        return dates;
    }

    public void setDates(List<DateRange> dates) {
        this.dates = dates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
