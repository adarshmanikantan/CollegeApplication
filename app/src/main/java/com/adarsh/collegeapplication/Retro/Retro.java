package com.adarsh.collegeapplication.Retro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {

    // create a method which returns our api interface class

    public Api getApi()
    {

        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://srishti-systems.info/projects/CollegeApp/").
                             addConverterFactory(GsonConverterFactory.create()).build();

        Api api=retrofit.create(Api.class);
        return api;

    }
    public Api getssaurav()
    {

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://sicspython.herokuapp.com/").
                addConverterFactory(GsonConverterFactory.create()).build();

        Api api=retrofit.create(Api.class);
        return api;

    }
}
