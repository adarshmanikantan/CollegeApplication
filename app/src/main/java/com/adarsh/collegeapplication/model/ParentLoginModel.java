package com.adarsh.collegeapplication.model;

public class ParentLoginModel {

    /**
     * status : Success
     * User_data : {"parent_id":"2","college_id":"1","parent_name":"Mani","email":"mani@gmail.com","phone":"906789131","regno":"1214299","password":"asdfg","stud_id":"4"}
     */

    private String status;
    private UserDataBean User_data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserDataBean getUser_data() {
        return User_data;
    }

    public void setUser_data(UserDataBean User_data) {
        this.User_data = User_data;
    }

    public static class UserDataBean {
        /**
         * parent_id : 2
         * college_id : 1
         * parent_name : Mani
         * email : mani@gmail.com
         * phone : 906789131
         * regno : 1214299
         * password : asdfg
         * stud_id : 4
         */

        private String parent_id;
        private String college_id;
        private String parent_name;
        private String email;
        private String phone;
        private String regno;
        private String password;
        private String stud_id;

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getCollege_id() {
            return college_id;
        }

        public void setCollege_id(String college_id) {
            this.college_id = college_id;
        }

        public String getParent_name() {
            return parent_name;
        }

        public void setParent_name(String parent_name) {
            this.parent_name = parent_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRegno() {
            return regno;
        }

        public void setRegno(String regno) {
            this.regno = regno;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getStud_id() {
            return stud_id;
        }

        public void setStud_id(String stud_id) {
            this.stud_id = stud_id;
        }
    }
}
