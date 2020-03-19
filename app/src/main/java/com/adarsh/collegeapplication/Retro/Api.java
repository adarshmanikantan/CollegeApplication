package com.adarsh.collegeapplication.Retro;

import com.adarsh.collegeapplication.model.AddAttendenceModel;
import com.adarsh.collegeapplication.model.AddDepartmentModel;
import com.adarsh.collegeapplication.model.AddEventModel;
import com.adarsh.collegeapplication.model.AddJobModel;
import com.adarsh.collegeapplication.model.AddNotesModel;
import com.adarsh.collegeapplication.model.AddQuestionsModel;
import com.adarsh.collegeapplication.model.AddStaffModel;
import com.adarsh.collegeapplication.model.AddStusdentModel;
import com.adarsh.collegeapplication.model.AddSyllabusModel;
import com.adarsh.collegeapplication.model.AlumniLoginModel;
import com.adarsh.collegeapplication.model.AlumniRegistrationModel;
import com.adarsh.collegeapplication.model.CollegeLoginModel;
import com.adarsh.collegeapplication.model.CollegeRegistrationModel;
import com.adarsh.collegeapplication.model.DeleteEventModel;
import com.adarsh.collegeapplication.model.EventUpdateModel;
import com.adarsh.collegeapplication.model.ParentLoginModel;
import com.adarsh.collegeapplication.model.ParentSignUpModel;
import com.adarsh.collegeapplication.model.SauravModel;
import com.adarsh.collegeapplication.model.StaffLoginModel;
import com.adarsh.collegeapplication.model.StudentLoginModel;
import com.adarsh.collegeapplication.model.ViewAttendenceModel;
import com.adarsh.collegeapplication.model.ViewDepartmentModel;
import com.adarsh.collegeapplication.model.ViewEventModel;
import com.adarsh.collegeapplication.model.ViewJobsModel;
import com.adarsh.collegeapplication.model.ViewJobsbyAlumniModel;
import com.adarsh.collegeapplication.model.ViewNotesModel;
import com.adarsh.collegeapplication.model.ViewQuestionByStaffModel;
import com.adarsh.collegeapplication.model.ViewQuestionModel;
import com.adarsh.collegeapplication.model.ViewStaffModel;
import com.adarsh.collegeapplication.model.ViewStudentModel;
import com.adarsh.collegeapplication.model.ViewSyllabusModel;
import com.adarsh.collegeapplication.model.ViewSyllabusbyStaffModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface Api {
    @GET("college_login.php?")
    Call<CollegeLoginModel>COLLEGE_LOGIN_MODEL_CALL(@Query("email")String email,@Query("password")String password);


    @GET("view_staff.php?")
    Call<ViewStaffModel>VIEW_STAFF_MODEL_CALL(@Query("college_id")String collegeId);

    @Multipart
    @POST("add_staff.php")
    Call<AddStaffModel>ADD_STAFF_MODEL_CALL(@Part("staff_name") RequestBody staff_name,
                                            @Part("emp_id") RequestBody emp_id,
                                            @Part("email") RequestBody email,
                                            @Part("phone") RequestBody phone,
                                            @Part("post") RequestBody post,
                                            @Part("department") RequestBody department,
                                            @Part("college_id") RequestBody collegId,
                                            @Part("password") RequestBody password,
                                            @Part MultipartBody.Part file);
    @GET("staff_login.php?")
    Call<StaffLoginModel>STAFF_LOGIN_MODEL_CALL(@Query("emp_id")String emp_id,@Query("password")String password);

    @GET("add_dept.php?")
    Call<AddDepartmentModel>ADD_DEPARTMENT_MODEL_CALL(@Query("dept_name")String department_name,@Query("college_id")String college_id);


    @GET("view_dept.php?")
    Call<ViewDepartmentModel>VIEW_DEPARTMENT_MODEL_CALL(@Query("college_id")String college_id);

    //college_id=1&event=Christmas%20Celebration&date=2019-12-23&description=Christmas%20celebration%20will%20be%20celebrated%20on%2023rd%202019.Students%20must%20be%20present%20by%2010:30am
    @GET("add_events.php?")
    Call<AddEventModel>ADD_EVENT_MODEL_CALL(@Query("college_id")String college_id,@Query("event")String event,@Query("date")String date,@Query("description")String description);

    @GET("view_events.php?")
    Call<ViewEventModel>VIEW_EVENT_MODEL_CALL(@Query("college_id")String collegeId);

    @GET("view_stud_dept.php?department=MCA&semester=4&college_id=1")
    Call<ViewStudentModel>VIEW_STUDENT_MODEL_CALL(@Query("department")String department,@Query("semester")String semester,@Query("college_id")String college_id);

    //http://srishti-systems.info/projects/CollegeApp/add_syllabus.php

    @Multipart
    @POST("add_syllabus.php")
    Call<AddSyllabusModel>ADD_SYLLABUS_MODEL_CALL(@Part("department") RequestBody department,
                                                  @Part("semester") RequestBody semester,
                                                  @Part("subject") RequestBody sub,
                                                  @Part("subcode") RequestBody subcode,
                                                  @Part MultipartBody.Part file,
                                                  @Part("college_id") RequestBody collegId,
                                                  @Part("id") RequestBody id
                                                 );
    @Multipart
    @POST("add_note.php")
    Call<AddNotesModel>ADD_NOTES_MODEL_CALL(@Part("department") RequestBody department,
                                               @Part("semester") RequestBody semester,
                                               @Part("subject") RequestBody sub,
                                               @Part("subcode") RequestBody subcode,
                                               @Part MultipartBody.Part file,
                                               @Part("college_id") RequestBody collegId,
                                               @Part("id") RequestBody id
    );

    @Multipart
    @POST("add_question_paper.php")
    Call<AddQuestionsModel>ADD_QUESTIONS_MODEL_CALL(@Part("department") RequestBody department,
                                                @Part("semester") RequestBody semester,
                                                @Part("subject") RequestBody sub,
                                                @Part("subcode") RequestBody subcode,
                                                @Part MultipartBody.Part file,
                                                @Part("college_id") RequestBody collegId,
                                                @Part("id") RequestBody id
    );

    @GET("view_syllabus.php?")
    Call<ViewSyllabusModel>VIEW_SYLLABUS_MODEL_CALL(@Query("department")String department,@Query("semester")String semester,@Query("college_id")String college_id);

    @GET("view_question.php?")
    Call<ViewQuestionModel>VIEW_QUESTION_MODEL_CALL(@Query("department")String department, @Query("semester")String semester, @Query("college_id")String college_id);

    @GET("view_imp_note.php?")
    Call<ViewNotesModel>VIEW_NOTES_MODEL_CALL(@Query("dept")String department,@Query("semester")String semester,@Query("college_id")String college_id);

    @GET("view_syllabus_bystaff.php?")
    Call<ViewSyllabusbyStaffModel>VIEW_SYLLABUSBY_STAFF_MODEL_CALL(@Query("id")String id);

    @GET("view_question_byid.php?")
    Call<ViewQuestionByStaffModel>VIEW_QUESTION_BY_STAFF_MODEL_CALL(@Query("id")String id);

    @GET(" view_notes_byid.php?")
    Call<ViewNotesModel>VIEW_NOTES_MODEL_CALL(@Query("id")String id);

    @GET("complaint/postcomplaint/")
    Call<List<SauravModel>>SAURAV_MODEL_CALL();


   // Params=["college_id"=1,"stud_name"=Lekshmi,"batch"=2018-2020,"reg_no"=1213199,"department"=MCA,"dob"=08061994,"stud_email"=lekshmi@gmail.com,"stud_phone"=8157073329,"parent_phone"=9495238529,"post"=HOD,avatar=pic.png,semester=4

    @Multipart
    @POST("add_student.php ")
    Call<AddStusdentModel>ADD_STUSDENT_MODEL_CALL(@Part("college_id")RequestBody college_id,
        @Part("stud_name")RequestBody studentname,@Part("batch")RequestBody batch,@Part("reg_no")RequestBody regno,
    @Part("department")RequestBody department,@Part("dob")RequestBody dob,@Part("stud_email")RequestBody email,
    @Part("stud_phone")RequestBody student_phone,@Part("parent_phone")RequestBody parentPhone,@Part("post")RequestBody post,
    @Part MultipartBody.Part file,@Part("semester")RequestBody semester);

    @GET("add_parent.php?")
    Call<ParentSignUpModel>PARENT_SIGN_UP_MODEL_CALL(@Query("parent_name")String parent_name,@Query("email")String email,@Query("phone")String phone,@Query("reg_no")String regno,@Query("password")String password);

     @GET("parent_login.php?")
     Call<ParentLoginModel>PARENT_LOGIN_MODEL_CALL(@Query("email")String email,@Query("password")String password);

     @Multipart
     @POST("college_reg.php")
     Call<CollegeRegistrationModel>COLLEGE_REGISTRATION_MODEL_CALL(@Part("college_name")RequestBody collegename,@Part("address")RequestBody address,
                                                                   @Part("email")RequestBody email,@Part("phone")RequestBody phone,@Part("password")RequestBody passwordreq,
                                                                   @Part MultipartBody.Part file);
      @GET("delete_event.php?college_id=1&event_id=2")
      Call<DeleteEventModel>DELETE_EVENT_MODEL_CALL(@Query("college_id")String collegeid,@Query("event_id")String event_id);

      @GET("edit_events.php?event=Arts%20Day&college_id=1&date=2020-06-30&description=College%20Arts%20Day%20on%2015.3%2018.%20Chief%20Guest%20will%20be%20famous%20dancer%20Smt%20Sithara%20Balakrishnan.%20Students%20selected%20from%20the%20Talent%20Hunt%20will%20perform%20for%20Arts%20day")
      Call<EventUpdateModel>EVENT_UPDATE_MODEL_CALL(@Query("event")String event,@Query("college_id")String college_id,@Query("date")String date,@Query("description")String description);

      @GET("student_login.php?")
    Call<StudentLoginModel>STUDENT_LOGIN_MODEL_CALL(@Query("stud_email")String email,@Query("reg_no")String regno);

      //college_id=1&reg_no=1214299&month=January&working=50&present=25
      @GET("add_attendance.php?")
      Call<AddAttendenceModel>ADD_ATTENDENCE_MODEL_CALL(@Query("college_id")String clgid,@Query("reg_no")String regno,@Query("month")String month,@Query("working")String working,@Query("present")String present);

      @GET("view_attendance.php?college_id=1&reg_no=1214299")
      Call<ViewAttendenceModel>VIEW_ATTENDENCE_MODEL_CALL(@Query("college_id")String collegeid,@Query("reg_no")String regno);

      @GET("alumni_reg.php?")
     Call<AlumniRegistrationModel>ALUMNI_REGISTRATION_MODEL_CALL(@Query("name")String name,@Query("email")String email,@Query("department")String department,@Query("passout")String passout,
                                                                 @Query("phone")String phone,@Query("password")String password,@Query("college_id")String college_id);

     @GET("alumni_login.php?email=aarthi.sics@gmail.com&password=qwerty")
     Call<AlumniLoginModel>ALUMNI_LOGIN_MODEL_CALL(@Query("email")String email,@Query("password")String password);

     @GET("add_job.php?")
    Call<AddJobModel>ADD_JOB_MODEL_CALL(@Query("alumni_id")String alumniid,@Query("college_id")String college_id,@Query("company")String company,@Query("title")String title,@Query("description")String desc);

    @GET("view_job_byid.php?")
    Call<ViewJobsbyAlumniModel>VIEW_JOBSBY_ALUMNI_MODEL_CALL(@Query("alumni_id")String alumniid, @Query("college_id")String college_id);

    @GET("view_job.php?")
    Call<ViewJobsModel>VIEW_JOBS_MODEL_CALL(@Query("college_id")String college_id);


}
