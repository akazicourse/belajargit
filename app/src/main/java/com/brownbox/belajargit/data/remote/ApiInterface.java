package com.brownbox.belajargit.data.remote;

import com.brownbox.belajargit.model.People;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/api/people/")
    Call<People> getAllPeoples();
}

