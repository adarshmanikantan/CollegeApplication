package com.adarsh.collegeapplication.model;

public class StudentLoginModel {

    /**
     * status : Success
     * Student_data : {"stud_id":"2","post":"HOD","college_id":"1","stud_name":"Athira","batch":"1","reg_no":"12131919","department":"computer science","dob":"08061994","stud_email":"athirasurendran.sics@gmail.com","stud_phone":"8157073329","parent_phone":"9495238529","stud_photo":"http://srishti-systems.info/projects/CollegeApp/uploads/749145-screenshot_20190318-114029.png","semester":""}
     */

    private String status;
    private StudentDataBean Student_data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentDataBean getStudent_data() {
        return Student_data;
    }

    public void setStudent_data(StudentDataBean Student_data) {
        this.Student_data = Student_data;
    }

    public static class StudentDataBean {
        /**
         * stud_id : 2
         * post : HOD
         * college_id : 1
         * stud_name : Athira
         * batch : 1
         * reg_no : 12131919
         * department : computer science
         * dob : 08061994
         * stud_email : athirasurendran.sics@gmail.com
         * stud_phone : 8157073329
         * parent_phone : 9495238529
         * stud_photo : http://srishti-systems.info/projects/CollegeApp/uploads/749145-screenshot_20190318-114029.png
         * semester :
         */

        private String stud_id;
        private String post;
        private String college_id;
        private String stud_name;
        private String batch;
        private String reg_no;
        private String department;
        private String dob;
        private String stud_email;
        private String stud_phone;
        private String parent_phone;
        private String stud_photo;
        private String semester;

        public String getStud_id() {
            return stud_id;
        }

        public void setStud_id(String stud_id) {
            this.stud_id = stud_id;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
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

        public String getStud_photo() {
            return stud_photo;
        }

        public void setStud_photo(String stud_photo) {
            this.stud_photo = stud_photo;
        }

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }
    }
}
