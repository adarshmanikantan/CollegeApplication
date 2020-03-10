package com.adarsh.collegeapplication.model;

import java.util.List;

public class ViewEventModel {

    /**
     * status : success
     * Events : [{"event_id":"1","college_id":"1","event":"Christmas Celebration","date":"2019-12-23","description":"Christmas celebration will be celebrated on 23rd 2019.Students must be present by 10:30am"},{"event_id":"3","college_id":"1","event":"Christmas Celebration","date":"2019-12-23","description":"Christmas celebration will be celebrated on 23rd 2019.Students must be present by 10:30am"},{"event_id":"4","college_id":"1","event":"Christmas Celebration","date":"2019-12-23","description":"Christmas celebration will be celebrated on 23rd 2019.Students must be present by 10:30am"},{"event_id":"5","college_id":"1","event":"Christmas Celebration","date":"2019-12-23","description":"Christmas celebration will be celebrated on 23rd 2019.Students must be present by 10:30am"}]
     */

    private String status;
    private List<EventsBean> Events;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EventsBean> getEvents() {
        return Events;
    }

    public void setEvents(List<EventsBean> Events) {
        this.Events = Events;
    }

    public static class EventsBean {
        /**
         * event_id : 1
         * college_id : 1
         * event : Christmas Celebration
         * date : 2019-12-23
         * description : Christmas celebration will be celebrated on 23rd 2019.Students must be present by 10:30am
         */

        private String event_id;
        private String college_id;
        private String event;
        private String date;
        private String description;

        public String getEvent_id() {
            return event_id;
        }

        public void setEvent_id(String event_id) {
            this.event_id = event_id;
        }

        public String getCollege_id() {
            return college_id;
        }

        public void setCollege_id(String college_id) {
            this.college_id = college_id;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
