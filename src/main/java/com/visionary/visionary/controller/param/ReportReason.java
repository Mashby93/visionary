package com.visionary.visionary.controller.param;

public class ReportReason {
    private Reason reason;
    private String details;

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public static enum Reason {
        SPAM, FRAUDULENT, OTHER
    }
}
