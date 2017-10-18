package com.example.nataliesmith.retro_fit_project;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by natalie.smith on 10/18/17.
 */

public class JokeInteracter
{
    JokePresenter presenter;

    public JokeInteracter(JokePresenter presenter)  //passing in the presenter class
    {
        this.presenter = presenter;
    }

    public void getJokesFromApi(String textSearch)
    {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://icanhazdadjoke.com")
                .addConverterFactory(GsonConverterFactory.create());  // adding the GSON converter

        Retrofit retrofit = builder.build();  //building the Retrofit

        JokesClient client = retrofit.create(JokesClient.class);   //creating connection to the JokesCLient Class
        Call<SearchJokes> call = client.searchJokes(textSearch);  // searching for "work" within the array in the searchJokes class

        call.enqueue(new Callback<SearchJokes>() {

            @Override
            public void onResponse(Call<SearchJokes> call, Response<SearchJokes> response) {
                SearchJokes joke = response.body();
                presenter.showJokes(joke);
            }

            @Override
            public void onFailure(Call<SearchJokes> call, Throwable t) {
                presenter.JokesFailed();
            }
        });
    }
}
