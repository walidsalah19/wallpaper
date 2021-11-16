package com.example.wallpaper.apis;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit {
     public static final String api="563492ad6f9170000100000137ed4840393a4e37bc9084fe842dc2be";
    public static Api getapi()
    {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.pexels.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
      return retrofit.create(Api.class);
    }
}
