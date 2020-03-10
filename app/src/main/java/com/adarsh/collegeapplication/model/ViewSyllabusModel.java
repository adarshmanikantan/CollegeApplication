package com.adarsh.collegeapplication.model;

import java.util.List;

public class ViewSyllabusModel {

    /**
     * status : success
     * Syllabus : [{"syl_id":"16","college_id":"1","staff_id":"31","department":"Physics","subject":"hshd","subcode":"hhhjj","files":"http://srishti-systems.info/projects/CollegeApp/uploads/648648-annexure3.pdf","semester":"2"},{"syl_id":"17","college_id":"1","staff_id":"31","department":"Physics","subject":"physics","subcode":"p1","files":"http://srishti-systems.info/projects/CollegeApp/uploads/196382-xii_physics_chapter-1--electric-charges_fields_saju_hsslive.pdf","semester":"2"}]
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
         * syl_id : 16
         * college_id : 1
         * staff_id : 31
         * department : Physics
         * subject : hshd
         * subcode : hhhjj
         * files : http://srishti-systems.info/projects/CollegeApp/uploads/648648-annexure3.pdf
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
