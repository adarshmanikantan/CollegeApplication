package com.adarsh.collegeapplication.Retro;

import com.adarsh.collegeapplication.model.AddStaffModel;
import com.adarsh.collegeapplication.model.CollegeLoginModel;
import com.adarsh.collegeapplication.model.SauravModel;
import com.adarsh.collegeapplication.model.StaffLoginModel;
import com.adarsh.collegeapplication.model.ViewStaffModel;

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



    @GET("complaint/postcomplaint/")
    Call<List<SauravModel>> SAURAV_MODEL_CALL();



}
