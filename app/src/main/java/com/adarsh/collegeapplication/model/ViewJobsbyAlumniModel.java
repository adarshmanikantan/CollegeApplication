package com.adarsh.collegeapplication.model;

import java.util.List;

public class ViewJobsbyAlumniModel {

    /**
     * status : success
     * Jobs : [{"alumni_id":"1","college_id":"1","company":"TCS","title":"Software Trainee","description":"IT","address":"Chennai"},{"alumni_id":"1","college_id":"1","company":"TCS","title":"Software Trainee","description":"IT","address":"Chennai"}]
     */

    private String status;
    private List<JobsBean> Jobs;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<JobsBean> getJobs() {
        return Jobs;
    }

    public void setJobs(List<JobsBean> Jobs) {
        this.Jobs = Jobs;
    }

    public static class JobsBean {
        /**
         * alumni_id : 1
         * college_id : 1
         * company : TCS
         * title : Software Trainee
         * description : IT
         * address : Chennai
         */

        private String alumni_id;
        private String college_id;
        private String company;
        private String title;
        private String description;
        private String address;

        public String getAlumni_id() {
            return alumni_id;
        }

        public void setAlumni_id(String alumni_id) {
            this.alumni_id = alumni_id;
        }

        public String getCollege_id() {
            return college_id;
        }

        public void setCollege_id(String college_id) {
            this.college_id = college_id;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
