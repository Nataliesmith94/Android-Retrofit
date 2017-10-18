package com.example.nataliesmith.retro_fit_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;    //Declaring variable names
    LinearLayoutManager jokeLayoutManager;
    JokeAdapter jokeAdapter;
    JokePresenter presenter;
    EditText jokeSearch;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view); // creating the recycler view

        jokeLayoutManager = new LinearLayoutManager(this); //creating layout manger for the recycler view
        recyclerView.setLayoutManager(jokeLayoutManager);

        jokeAdapter = new JokeAdapter(); //creating the adapter
        recyclerView.setAdapter(jokeAdapter);

        presenter = new JokePresenter(this); //passing the view to the presenter by using this

        jokeSearch = (EditText) findViewById(R.id.input_search);
        searchButton = (Button) findViewById(R.id.button_search);

        searchButton.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        String textSearch = jokeSearch.getText().toString().trim();

                        presenter.inputtedText(textSearch);
                    }
                }
        );


    }



    public void successfulJoke(ArrayList<Joke> jokes)  //links to method in adapter
    {
        jokeAdapter.addJokes(jokes); //passing in jokes to add Jokes method
    }

    public void jokeFailed() //will eventually link to adapter
    {
        Log.d("MainActivity", "Jokes failed to load");
    }
}
