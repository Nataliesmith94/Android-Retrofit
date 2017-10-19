package com.example.nataliesmith.retro_fit_project;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;    //Declaring variable names
    LinearLayoutManager jokeLayoutManager;
    JokeAdapter jokeAdapter;
    JokePresenter presenter;
    EditText jokeSearch;
    Button searchButton;
    ProgressBar progressBar;
    InputMethodManager imm;
    TextView errorText;

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
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        errorText = (TextView) findViewById(R.id.text_error);

        searchButton.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        String textSearch = jokeSearch.getText().toString().trim();
                        presenter.inputtedText(textSearch);

                        DismissKeyboard();
                    }
                }
        );
    }

    public void successfulJoke(ArrayList<Joke> jokes)  //links to method in adapter
    {
        jokeAdapter.addJokes(jokes);//passing in jokes to add Jokes methoddog
        errorText.setVisibility(View.GONE);
    }

    public void jokeFailed() //will eventually link to adapter
    {
        errorText.setVisibility(View.VISIBLE);
        errorText.setText("No Results, Please Enter another Search");
    }

    public void hideLoading()
    {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    public void showLoading()
    {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    public void DismissKeyboard()
    {
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }


}
