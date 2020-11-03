package com.visionary.visionary.domain;

import com.visionary.visionary.model.DateRange;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "plot")
public class Event extends AbstractEntity {
    private List<DateRange> dates;


}
