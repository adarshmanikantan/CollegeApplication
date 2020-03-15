package com.adarsh.collegeapplication.model;

import java.util.List;

public class ViewQuestionByStaffModel {

    /**
     * status : success
     * quesion_paper : [{"qid":"3","college_id":"1","department":"Physics","subject":"Physics","subcode":"PS12001","files":"http://srishti-systems.info/projects/CollegeApp/uploads/415829-download-physics-question-paper-compartment-2018-set-(1).pdf","semester":"2"}]
     */

    private String status;
    private List<QuesionPaperBean> quesion_paper;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<QuesionPaperBean> getQuesion_paper() {
        return quesion_paper;
    }

    public void setQuesion_paper(List<QuesionPaperBean> quesion_paper) {
        this.quesion_paper = quesion_paper;
    }

    public static class QuesionPaperBean {
        /**
         * qid : 3
         * college_id : 1
         * department : Physics
         * subject : Physics
         * subcode : PS12001
         * files : http://srishti-systems.info/projects/CollegeApp/uploads/415829-download-physics-question-paper-compartment-2018-set-(1).pdf
         * semester : 2
         */

        private String qid;
        private String college_id;
        private String department;
        private String subject;
        private String subcode;
        private String files;
        private String semester;

        public String getQid() {
            return qid;
        }

        public void setQid(String qid) {
            this.qid = qid;
        }

        public String getCollege_id() {
            return college_id;
        }

        public void setCollege_id(String college_id) {
            this.college_id = college_id;
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
