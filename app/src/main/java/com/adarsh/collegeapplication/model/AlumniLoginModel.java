package com.adarsh.collegeapplication.model;

public class AlumniLoginModel {

    /**
     * status : Success
     * User_data : {"alumni_id":"1","name":"Aarthi","email":"aarthi.sics@gmail.com","department":"MCA","passout":"2018","phone":"9791369503","password":"qwerty","college_id":"1"}
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
         * alumni_id : 1
         * name : Aarthi
         * email : aarthi.sics@gmail.com
         * department : MCA
         * passout : 2018
         * phone : 9791369503
         * password : qwerty
         * college_id : 1
         */

        private String alumni_id;
        private String name;
        private String email;
        private String department;
        private String passout;
        private String phone;
        private String password;
        private String college_id;

        public String getAlumni_id() {
            return alumni_id;
        }

        public void setAlumni_id(String alumni_id) {
            this.alumni_id = alumni_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getPassout() {
            return passout;
        }

        public void setPassout(String passout) {
            this.passout = passout;
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

        public String getCollege_id() {
            return college_id;
        }

        public void setCollege_id(String college_id) {
            this.college_id = college_id;
        }
    }
}
