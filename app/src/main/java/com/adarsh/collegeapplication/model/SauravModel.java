package com.adarsh.collegeapplication.model;

public class SauravModel {

    /**
     * id : 1
     * owner_id : 2
     * Police_Station : Thumba
     * Complaint_type : xzzxx
     * District : Trivandrum
     * Place_of_occurence : zxzzxz
     * Date_time : 2020-02-27
     * Details : zzzzzxzxx
     */

    private int id;
    private int owner_id;
    private String Police_Station;
    private String Complaint_type;
    private String District;
    private String Place_of_occurence;
    private String Date_time;
    private String Details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getPolice_Station() {
        return Police_Station;
    }

    public void setPolice_Station(String Police_Station) {
        this.Police_Station = Police_Station;
    }

    public String getComplaint_type() {
        return Complaint_type;
    }

    public void setComplaint_type(String Complaint_type) {
        this.Complaint_type = Complaint_type;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getPlace_of_occurence() {
        return Place_of_occurence;
    }

    public void setPlace_of_occurence(String Place_of_occurence) {
        this.Place_of_occurence = Place_of_occurence;
    }

    public String getDate_time() {
        return Date_time;
    }

    public void setDate_time(String Date_time) {
        this.Date_time = Date_time;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }
}
