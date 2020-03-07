package com.adarsh.collegeapplication.model;

import java.util.List;

public class ViewStaffModel {

    /**
     * status : success
     * Staffs : [{"id":"2","emp_id":"cc1001","staff_name":"Anu","email":"anu@gmail.com","phone":"9876543210","gender":"femail","post":"HOD","department":"MCA","photo":"http://srishti-systems.info/projects/CollegeApp/uploads/421253-1-flower-drawings-rose.jpg","college_id":"1"},{"id":"3","emp_id":"cc1002","staff_name":"Ammu","email":"ammu@gmail.com","phone":"9776543210","gender":"femail","post":"Assi.Prof","department":"MCA","photo":"http://srishti-systems.info/projects/CollegeApp/uploads/965294-2.jpg","college_id":"1"}]
     */

    private String status;
    private List<StaffsBean> Staffs;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StaffsBean> getStaffs() {
        return Staffs;
    }

    public void setStaffs(List<StaffsBean> Staffs) {
        this.Staffs = Staffs;
    }

    public static class StaffsBean {
        /**
         * id : 2
         * emp_id : cc1001
         * staff_name : Anu
         * email : anu@gmail.com
         * phone : 9876543210
         * gender : femail
         * post : HOD
         * department : MCA
         * photo : http://srishti-systems.info/projects/CollegeApp/uploads/421253-1-flower-drawings-rose.jpg
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
