package com.visionary.visionary.domain;

import com.visionary.visionary.controller.param.ReportReason;
import com.visionary.visionary.domain.Auditable;

import javax.persistence.*;

@Entity
public class Report extends Auditable {
    private ReportReason reportReason;
    @OneToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public ReportReason getReportReason() {
        return reportReason;
    }

    public void setReportReason(ReportReason reportReason) {
        this.reportReason = reportReason;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
