package com.adarsh.collegeapplication.model;

import java.util.List;

public class ViewStudentModel {

    /**
     * status : success
     * Students : [{"id":"4","college_id":"1","stud_name":"Lekshmi","batch":"2018-2020","reg_no":"1214299","department":"MCA","dob":"09/07/1996","stud_email":"lekshmi@gmail.com","stud_phone":"90876543210","parent_phone":"87654321908","semester":"4","stud_photo":"http://srishti-systems.info/projects/CollegeApp/uploads/960420-g1.jpg"}]
     */

    private String status;
    private List<StudentsBean> Students;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StudentsBean> getStudents() {
        return Students;
    }

    public void setStudents(List<StudentsBean> Students) {
        this.Students = Students;
    }

    public static class StudentsBean {
        /**
         * id : 4
         * college_id : 1
         * stud_name : Lekshmi
         * batch : 2018-2020
         * reg_no : 1214299
         * department : MCA
         * dob : 09/07/1996
         * stud_email : lekshmi@gmail.com
         * stud_phone : 90876543210
         * parent_phone : 87654321908
         * semester : 4
         * stud_photo : http://srishti-systems.info/projects/CollegeApp/uploads/960420-g1.jpg
         */

        private String id;
        private String college_id;
        private String stud_name;
        private String batch;
        private String reg_no;
        private String department;
        private String dob;
        private String stud_email;
        private String stud_phone;
        private String parent_phone;
        private String semester;
        private String stud_photo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCollege_id() {
            return college_id;
        }

        public void setCollege_id(String college_id) {
            this.college_id = college_id;
        }

        public String getStud_name() {
            return stud_name;
        }

        public void setStud_name(String stud_name) {
            this.stud_name = stud_name;
        }

        public String getBatch() {
            return batch;
        }

        public void setBatch(String batch) {
            this.batch = batch;
        }

        public String getReg_no() {
            return reg_no;
        }

        public void setReg_no(String reg_no) {
            this.reg_no = reg_no;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getStud_email() {
            return stud_email;
        }

        public void setStud_email(String stud_email) {
            this.stud_email = stud_email;
        }

        public String getStud_phone() {
            return stud_phone;
        }

        public void setStud_phone(String stud_phone) {
            this.stud_phone = stud_phone;
        }

        public String getParent_phone() {
            return parent_phone;
        }

        public void setParent_phone(String parent_phone) {
            this.parent_phone = parent_phone;
        }

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }

        public String getStud_photo() {
            return stud_photo;
        }

        public void setStud_photo(String stud_photo) {
            this.stud_photo = stud_photo;
        }
    }
}
