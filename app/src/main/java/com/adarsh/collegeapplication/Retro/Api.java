package com.adarsh.collegeapplication.Retro;

import com.adarsh.collegeapplication.model.AddDepartmentModel;
import com.adarsh.collegeapplication.model.AddEventModel;
import com.adarsh.collegeapplication.model.AddStaffModel;
import com.adarsh.collegeapplication.model.AddStusdentModel;
import com.adarsh.collegeapplication.model.AddSyllabusModel;
import com.adarsh.collegeapplication.model.CollegeLoginModel;
import com.adarsh.collegeapplication.model.CollegeRegistrationModel;
import com.adarsh.collegeapplication.model.ParentLoginModel;
import com.adarsh.collegeapplication.model.ParentSignUpModel;
import com.adarsh.collegeapplication.model.SauravModel;
import com.adarsh.collegeapplication.model.StaffLoginModel;
import com.adarsh.collegeapplication.model.ViewDepartmentModel;
import com.adarsh.collegeapplication.model.ViewEventModel;
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

    @GET("view_syllabus.php?")
    Call<ViewSyllabusModel>VIEW_SYLLABUS_MODEL_CALL(@Query("department")String department,@Query("semester")String semester,@Query("college_id")String college_id);

    @GET("view_syllabus_bystaff.php?id=31")
    Call<ViewSyllabusbyStaffModel>VIEW_SYLLABUSBY_STAFF_MODEL_CALL(@Query("id")String id);
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

     @POST("college_reg.php")
     Call<CollegeRegistrationModel>COLLEGE_REGISTRATION_MODEL_CALL(@Part("college_name")RequestBody collegename,@Part("address")RequestBody address,
                                                                   @Part("email")RequestBody email,@Part("phone")RequestBody phone,@Part("password")RequestBody passwordreq,
                                                                   @Part MultipartBody.Part file);

}
