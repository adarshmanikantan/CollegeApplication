package com.adarsh.collegeapplication.model;

import java.util.List;

public class ViewDepartmentModel {

    /**
     * status : success
     * Departments : [{"dept_id":"1","dept_name":"MBA"},{"dept_id":"2","dept_name":"MCA"},{"dept_id":"4","dept_name":"MCA"}]
     */

    private String status;
    private List<DepartmentsBean> Departments;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DepartmentsBean> getDepartments() {
        return Departments;
    }

    public void setDepartments(List<DepartmentsBean> Departments) {
        this.Departments = Departments;
    }

    public static class DepartmentsBean {
        /**
         * dept_id : 1
         * dept_name : MBA
         */

        private String dept_id;
        private String dept_name;

        public String getDept_id() {
            return dept_id;
        }

        public void setDept_id(String dept_id) {
            this.dept_id = dept_id;
        }

        public String getDept_name() {
            return dept_name;
        }

        public void setDept_name(String dept_name) {
            this.dept_name = dept_name;
        }
    }
}
