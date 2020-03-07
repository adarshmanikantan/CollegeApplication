package com.adarsh.collegeapplication.model;

public class CollegeLoginModel {

    /**
     * status : Success
     * User_data : {"college_id":"1","college_name":"Noorul Islam College of Arts and Science","address":"Kulasekharam Thuckalay Rd, Kumaracoil","email":"nicollege@gmail.com","phone":"2147483647","password":"qwerty","logo":"http://srishti-systems.info/projects/CollegeApp/uploads/234772-ni.jpg"}
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
         * college_id : 1
         * college_name : Noorul Islam College of Arts and Science
         * address : Kulasekharam Thuckalay Rd, Kumaracoil
         * email : nicollege@gmail.com
         * phone : 2147483647
         * password : qwerty
         * logo : http://srishti-systems.info/projects/CollegeApp/uploads/234772-ni.jpg
         */

        private String college_id;
        private String college_name;
        private String address;
        private String email;
        private String phone;
        private String password;
        private String logo;

        public String getCollege_id() {
            return college_id;
        }

        public void setCollege_id(String college_id) {
            this.college_id = college_id;
        }

        public String getCollege_name() {
            return college_name;
        }

        public void setCollege_name(String college_name) {
            this.college_name = college_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }
    }
}
