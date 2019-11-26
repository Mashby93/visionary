package com.visionary.visionary.domain;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.UUID;

public class Review extends Identifiable{
    @OneToMany
    @Column(name = "event_id")
    private Event eventId;
    private Double rating;
    private String review;

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
