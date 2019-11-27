package com.visionary.visionary.controller.filter;

import com.visionary.visionary.controller.param.ReportReason;

import java.util.UUID;

public class ReportFilters {
    private UUID reporterId;
    private UUID eventId;
    private UUID userId;
    private ReportReason.Reason reason;

    public UUID getReporterId() {
        return reporterId;
    }

    public void setReporterId(UUID reporterId) {
        this.reporterId = reporterId;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public ReportReason.Reason getReason() {
        return reason;
    }

    public void setReason(ReportReason.Reason reason) {
        this.reason = reason;
    }
}
