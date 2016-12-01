package com.example.hunter.workout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

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
        View fragmentContainer=findViewById(R.id.fragment_container);
        if(fragmentContainer!=null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            details.setWorkout(id);
            ft.replace(R.id.fragment_container, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        else{
            Intent intent=new Intent(this,DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID,(int)id);
            startActivity(intent);

        }

    }
}
