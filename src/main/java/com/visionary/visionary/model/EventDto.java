package com.visionary.visionary.model;

public class EventDto {
    private String id;
    private PublicUserProfileDto userProfile;
    private String address;
    private String title;
    private String description;
    private String date;
    private String startTime;
    private String endTime;
    private CategoryDto categoryDto;
    private Long savedCount;
    private Boolean saved;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public Long getSavedCount() {
        return savedCount;
    }

    public void setSavedCount(Long savedCount) {
        this.savedCount = savedCount;
    }

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    public PublicUserProfileDto getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(PublicUserProfileDto userProfile) {
        this.userProfile = userProfile;
    }
}
