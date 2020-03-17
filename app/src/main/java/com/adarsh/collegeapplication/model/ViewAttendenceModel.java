package com.adarsh.collegeapplication.model;

import java.util.List;

public class ViewAttendenceModel {

    /**
     * status : success
     * Attendance : [{"attendance_id":"1","college_id":"1","reg_no":"1214299","month":"January","working":"50","present":"25","Percentage":"50"},{"attendance_id":"2","college_id":"1","reg_no":"1214299","month":"January","working":"50","present":"25","Percentage":"50"},{"attendance_id":"3","college_id":"1","reg_no":"1214299","month":"January","working":"50","present":"25","Percentage":"50"},{"attendance_id":"4","college_id":"1","reg_no":"1214299","month":"January","working":"50","present":"25","Percentage":"50"},{"attendance_id":"5","college_id":"1","reg_no":"1214299","month":"January","working":"50","present":"25","Percentage":"50"}]
     */

    private String status;
    private List<AttendanceBean> Attendance;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AttendanceBean> getAttendance() {
        return Attendance;
    }

    public void setAttendance(List<AttendanceBean> Attendance) {
        this.Attendance = Attendance;
    }

    public static class AttendanceBean {
        /**
         * attendance_id : 1
         * college_id : 1
         * reg_no : 1214299
         * month : January
         * working : 50
         * present : 25
         * Percentage : 50
         */

        private String attendance_id;
        private String college_id;
        private String reg_no;
        private String month;
        private String working;
        private String present;
        private String Percentage;

        public String getAttendance_id() {
            return attendance_id;
        }

        public void setAttendance_id(String attendance_id) {
            this.attendance_id = attendance_id;
        }

        public String getCollege_id() {
            return college_id;
        }

        public void setCollege_id(String college_id) {
            this.college_id = college_id;
        }

        public String getReg_no() {
            return reg_no;
        }

        public void setReg_no(String reg_no) {
            this.reg_no = reg_no;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getWorking() {
            return working;
        }

        public void setWorking(String working) {
            this.working = working;
        }

        public String getPresent() {
            return present;
        }

        public void setPresent(String present) {
            this.present = present;
        }

        public String getPercentage() {
            return Percentage;
        }

        public void setPercentage(String Percentage) {
            this.Percentage = Percentage;
        }
    }
}
