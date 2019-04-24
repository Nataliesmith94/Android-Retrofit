package com.example.nataliesmith.retro_fit_project;

import java.util.ArrayList;

/**
 * Created by natalie.smith on 10/18/17.
 */

public class JokePresenter {

    MainActivity view;   //declaring the variable names
    JokeInteracter interacter;

    public JokePresenter(MainActivity activity)
    {
        view = activity;
        interacter = new JokeInteracter(this); //passing the presenter to the interacter by using this
    }

    public void getJokes(String textSearch)
    {
        view.showLoading();
        interacter.getJokesFromApi(textSearch); //going to get jokes method in api
    }


    public void inputtedText(String textSearch)
    {
        if (textSearch.length() > 0)
        {
            getJokes(textSearch);
        }
        else
        {
            JokesFailed();
        }
    }

    public void showJokes(SearchJokes searchJokes) //passing in the search jokes class
    {
        delayLoading();

        view.hideLoading();
        ArrayList<Joke> jokes = searchJokes.getJokes();

        if (jokes == null || jokes.size() == 0)
        {
            JokesFailed();
        }
        else
        {
            view.successfulJoke(jokes);
        }
    }

    public void JokesFailed()
    {
        view.jokeFailed();
    }

    private void delayLoading()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
