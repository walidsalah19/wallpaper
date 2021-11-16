package com.example.wallpaper.apis;

import com.example.wallpaper.gson_class.gson_class;
import com.example.wallpaper.gson_class.searchmodel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import static com.example.wallpaper.apis.retrofit.api;
public interface Api {

    @Headers("Authorization: "+api)
    @GET("curated")
    Call<searchmodel> getdata(
            @Query("page") int page,
            @Query("per_page") int per_page
    );
    @Headers("Authorization: "+api)
    @GET("search")
    Call<searchmodel> search(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int pageSize
    );
}
