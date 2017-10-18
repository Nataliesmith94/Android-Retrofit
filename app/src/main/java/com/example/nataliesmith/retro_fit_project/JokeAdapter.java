package com.example.nataliesmith.retro_fit_project;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by natalie.smith on 10/17/17.
 */

public class JokeAdapter extends RecyclerView.Adapter< JokeAdapter.JokeViewHolder>  {

    private ArrayList<Joke> adapterData; //creating Joke array list variable

    public JokeAdapter() //constructor
    {
        adapterData = new ArrayList();
    }

    @Override
    public JokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  //create new views
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewGroup v = (ViewGroup) inflater.from(parent.getContext()).inflate(R.layout.text_row, parent, false);

        JokeViewHolder vh = new JokeViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(JokeViewHolder holder, int position)
    {
        Joke outputString = adapterData.get(position);
        holder.textOutput.setText(outputString.getJokeText());
    }

    @Override
    public int getItemCount()
    {
        return adapterData.size();
    }  //getting the size of the array

    public void addJokes(ArrayList<Joke> dataStrings)
    {
        adapterData.clear();
        if (dataStrings != null)
        {
            adapterData.addAll(dataStrings);
        }
        notifyDataSetChanged();
    }



    public static class JokeViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textOutput;

        public JokeViewHolder(View v) {
            super(v);
            textOutput = v.findViewById(R.id.text_output);

        }
    }

}
