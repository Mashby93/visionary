package com.visionary.visionary.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class SavedEvent extends Auditable{
    @OneToOne
    private Event eventId;

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }
}
