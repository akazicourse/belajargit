package com.brownbox.belajargit.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.swapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }

}


