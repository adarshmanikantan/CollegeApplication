package com.adarsh.collegeapplication.model;

public class AddNotesModel {

    /**
     * status : success
     * error : false
     * message : Inserted successfully
     * url : http://srishti-systems.info/projects/CollegeApp/uploads/795047-0be8a67e8978cd0d3a377eacf647fb57.jpg
     */

    private String status;
    private boolean error;
    private String message;
    private String url;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
