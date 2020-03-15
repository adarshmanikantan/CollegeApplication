package com.adarsh.collegeapplication.model;

import java.util.List;

public class ViewNotesModel {

    /**
     * status : success
     * note : [{"imp_id":"1","college_id":"1","department":"ComputerScience","subject":"Mathematics","subcode":"cs10002","files":"http://srishti-systems.info/projects/CollegeApp/uploads/840800-kripa_iv-_front.pdf","semester":"2"}]
     */

    private String status;
    private List<NoteBean> note;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<NoteBean> getNote() {
        return note;
    }

    public void setNote(List<NoteBean> note) {
        this.note = note;
    }

    public static class NoteBean {
        /**
         * imp_id : 1
         * college_id : 1
         * department : ComputerScience
         * subject : Mathematics
         * subcode : cs10002
         * files : http://srishti-systems.info/projects/CollegeApp/uploads/840800-kripa_iv-_front.pdf
         * semester : 2
         */

        private String imp_id;
        private String college_id;
        private String department;
        private String subject;
        private String subcode;
        private String files;
        private String semester;

        public String getImp_id() {
            return imp_id;
        }

        public void setImp_id(String imp_id) {
            this.imp_id = imp_id;
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
