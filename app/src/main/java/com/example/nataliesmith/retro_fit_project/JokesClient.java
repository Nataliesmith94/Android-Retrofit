package com.example.nataliesmith.retro_fit_project;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by natalie.smith on 10/17/17.
 */

public interface JokesClient {

    @GET("/search") //extension on the url
    @Headers("Accept: application/json")  //what format the data will be in
    Call<SearchJokes> searchJokes(@Query("term") String searchString);  //the search within the url
}