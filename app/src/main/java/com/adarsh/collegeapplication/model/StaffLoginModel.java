package com.adarsh.collegeapplication.model;

public class StaffLoginModel {

    /**
     * status : Success
     * User_data : {"id":"31","emp_id":"AM101","staff_name":"Adarsh M","email":"adarshmanikantan10@gmail.com","phone":"9074937901","gender":"","post":"HOD","department":"Physics","password":"1947","photo":"http://srishti-systems.info/projects/CollegeApp/uploads/555447-img-20191213-wa0075.jpg","college_id":"1"}
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
         * id : 31
         * emp_id : AM101
         * staff_name : Adarsh M
         * email : adarshmanikantan10@gmail.com
         * phone : 9074937901
         * gender :
         * post : HOD
         * department : Physics
         * password : 1947
         * photo : http://srishti-systems.info/projects/CollegeApp/uploads/555447-img-20191213-wa0075.jpg
         * college_id : 1
         */

        private String id;
        private String emp_id;
        private String staff_name;
        private String email;
        private String phone;
        private String gender;
        private String post;
        private String department;
        private String password;
        private String photo;
        private String college_id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmp_id() {
            return emp_id;
        }

        public void setEmp_id(String emp_id) {
            this.emp_id = emp_id;
        }

        public String getStaff_name() {
            return staff_name;
        }

        public void setStaff_name(String staff_name) {
            this.staff_name = staff_name;
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

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getCollege_id() {
            return college_id;
        }

        public void setCollege_id(String college_id) {
            this.college_id = college_id;
        }
    }
}
