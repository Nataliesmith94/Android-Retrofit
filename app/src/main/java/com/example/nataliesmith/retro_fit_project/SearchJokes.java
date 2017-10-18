package com.example.nataliesmith.retro_fit_project;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by natalie.smith on 10/17/17.
 */

public class SearchJokes {

    @SerializedName("status")  //variable in the url
    int status;                //variable in android

    @SerializedName("results")
    ArrayList<Joke> jokes;  //variable in android

    public int getStatus() {
        return status;
    } //getters for status

    public void setStatus(int status) {
        this.status = status;
    } //setter for status

    public ArrayList<Joke> getJokes() {
        return jokes;
    } //getter for Joke array list

    public void setJokes(ArrayList<Joke> jokes) {  this.jokes = jokes; }  //setter for joke array list

}
