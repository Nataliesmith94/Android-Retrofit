package com.example.nataliesmith.retro_fit_project;

import com.google.gson.annotations.SerializedName;

/**
 * Created by natalie.smith on 10/17/17.
 */

public class Joke {

    @SerializedName("id")
    private String jokeId;

    @SerializedName("joke")
    private String jokeText;

    public String getJokeId() { return jokeId; }

    public void setJokeId(String jokeId) {
        this.jokeId = jokeId;
    }

    public String getJokeText() { return jokeText; }

    public void setJokeText(String jokeText) { this.jokeText = jokeText; }
}
