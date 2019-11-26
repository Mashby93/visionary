package com.visionary.visionary.controller.filter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class EventFilter implements Filters{
    private List<UUID> categoryIdList;
    private Date startDate;
    private Date endDate;

    public List<UUID> getCategoryIdList() {
        return categoryIdList;
    }

    public void setCategoryIdList(List<UUID> categoryIdList) {
        this.categoryIdList = categoryIdList;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
