package com.example.hunter.workout;

import android.app.Activity;

import android.app.Fragment;
import android.os.Bundle;


import static com.example.hunter.workout.R.id.detail_frag;


public class MainActivity extends Activity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @Override
    public void itemClicked(long id)
    {
        //the code to set the detail will go here

    }
}
