package com.visionary.visionary.domain;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.UUID;
@Entity
public class Review extends Identifiable{
    @ManyToOne
    @JoinColumn(name = "event_id")
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
