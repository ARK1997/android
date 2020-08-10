package com.example.customlistview_bloodgroup;

import androidx.annotation.Nullable;

class BuildingData {

 private String ID;
 private String status;
 private String detail;
 private String place;
    private String days;
    private String department;
    private String priority;
    private String type;
    private int main_image;
    private int second_image;

    public BuildingData(String ID, String status, String detail, String place, String days, String department, String priority, @Nullable String type, int main_image, int second_image) {
        this.ID = ID.toUpperCase();
        this.status = status.toUpperCase();
        this.detail = detail;
        this.place = place;
        this.days = days;
        this.department = department;
        this.priority = priority;
        this.type = type;
        this.main_image = main_image;
        this.second_image = second_image;
    }

    public String getID() {
        return ID;
    }

    public String getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public String getPlace() {
        return place;
    }

    public String getDays() {
        return days;
    }

    public String getDepartment() {
        return department;
    }

    public String getPriority() {
        return priority;
    }

    public String getType() {
        return type;
    }

    public int getMain_image() {
        return main_image;
    }

    public int getSecond_image() {
        return second_image;
    }

}
