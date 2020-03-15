package com.adarsh.collegeapplication.model;

import java.util.List;

public class ViewSyllabusStudentModule {

    /**
     * status : success
     * Syllabus : [{"syl_id":"2","college_id":"1","staff_id":"1","department":"MCA","subject":"Maths","subcode":"122000","files":"http://srishti-systems.info/projects/CollegeApp/uploads/443169-m-power-content.pdf","semester":"2"},{"syl_id":"3","college_id":"1","staff_id":"1","department":"MCA","subject":"Maths","subcode":"122000","files":"http://srishti-systems.info/projects/CollegeApp/uploads/273825-vipin-front.pdf","semester":"2"},{"syl_id":"4","college_id":"1","staff_id":"1","department":"MCA","subject":"Maths1","subcode":"122000","files":"","semester":"2"},{"syl_id":"5","college_id":"1","staff_id":"1","department":"MCA","subject":"Maths1","subcode":"122000","files":"","semester":"2"},{"syl_id":"6","college_id":"1","staff_id":"1","department":"MCA","subject":"Maths1","subcode":"122000","files":"","semester":"2"},{"syl_id":"7","college_id":"1","staff_id":"1","department":"MCA","subject":"Maths1","subcode":"122000","files":"http://srishti-systems.info/projects/CollegeApp/uploads/687239-1.jpeg","semester":"2"},{"syl_id":"8","college_id":"1","staff_id":"1","department":"MCA","subject":"Maths1","subcode":"122000","files":"http://srishti-systems.info/projects/CollegeApp/uploads/736396-1.jpeg","semester":"2"},{"syl_id":"9","college_id":"1","staff_id":"1","department":"MCA","subject":"Maths1","subcode":"122000","files":"","semester":"2"},{"syl_id":"10","college_id":"1","staff_id":"1","department":"MCA","subject":"Maths1","subcode":"122000","files":"","semester":"2"},{"syl_id":"20","college_id":"1","staff_id":"1","department":"MCA","subject":"Maths1","subcode":"122000","files":"http://srishti-systems.info/projects/CollegeApp/uploads/496926-vipin-front.pdf","semester":"2"}]
     */

    private String status;
    private List<SyllabusBean> Syllabus;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SyllabusBean> getSyllabus() {
        return Syllabus;
    }

    public void setSyllabus(List<SyllabusBean> Syllabus) {
        this.Syllabus = Syllabus;
    }

    public static class SyllabusBean {
        /**
         * syl_id : 2
         * college_id : 1
         * staff_id : 1
         * department : MCA
         * subject : Maths
         * subcode : 122000
         * files : http://srishti-systems.info/projects/CollegeApp/uploads/443169-m-power-content.pdf
         * semester : 2
         */

        private String syl_id;
        private String college_id;
        private String staff_id;
        private String department;
        private String subject;
        private String subcode;
        private String files;
        private String semester;

        public String getSyl_id() {
            return syl_id;
        }

        public void setSyl_id(String syl_id) {
            this.syl_id = syl_id;
        }

        public String getCollege_id() {
            return college_id;
        }

        public void setCollege_id(String college_id) {
            this.college_id = college_id;
        }

        public String getStaff_id() {
            return staff_id;
        }

        public void setStaff_id(String staff_id) {
            this.staff_id = staff_id;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getSubcode() {
            return subcode;
        }

        public void setSubcode(String subcode) {
            this.subcode = subcode;
        }

        public String getFiles() {
            return files;
        }

        public void setFiles(String files) {
            this.files = files;
        }

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }
    }
}
