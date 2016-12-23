package com.example.hunter.workout;


import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment implements View.OnClickListener{
    //Number of seconds displayed on the stopwatch
    private int seconds = 0;
    //is the stopwatch running?
    private boolean running;
    //
    private boolean wasRunning;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        if (savedInstance != null) {
            seconds = savedInstance.getInt("seconds");
            running = savedInstance.getBoolean("running");
            wasRunning = savedInstance.getBoolean("wasRunning");

            if(wasRunning)
            {
                running=true;

            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        View layout=inflater.inflate(R.layout.fragment_stopwatch,container,false);
        runTimer(layout);
        Button startButton=(Button)layout.findViewById(R.id.start_button);
        startButton.setOnClickListener(this);
        Button stopButton=(Button)layout.findViewById(R.id.stop_button);
        stopButton.setOnClickListener(this);
        Button resetButton=(Button)layout.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(this);

        return layout;

    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.start_button:
                onClickStart(v);
                break;
            case R.id.stop_button:
                onClickStop(v);
                break;
            case R.id.reset_button:
                onClickReset(v);
                break;

        }
    }
    @Override
    public void onPause()
    {
        super.onPause();
        wasRunning=running;
        running=false;

    }
    @Override
    public void onResume()
    {
        super.onResume();
        if(wasRunning)
            running=true;

    }

    public void onSaveInstanceState(Bundle savedInstance)
    {
        savedInstance.putInt("seconds", seconds);
        savedInstance.putBoolean("running", running);
        savedInstance.putBoolean("wasRunning", wasRunning);

    }

    //Start the stopwatch running when the Start button is clicked
    public void onClickStart(View view) {

        running = true;

    }

    public void onClickStop(View view) {
        running = false;

    }

    public void onClickReset(View view) {
        running = false;
        seconds = 0;

    }
    /*
    @Override
    protected void onStop(){
        super.onStop();
        wasRunning=running;
        running=false;
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(wasRunning)
        {
            running=true;

        }
    }
*/

    private void runTimer(View view){
        final TextView timeView=(TextView) view.findViewById(R.id.time_view);
        final Handler handler=new Handler();
        handler.post(new Runnable(){

            @Override
            public void run(){
                int hours=seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs=seconds%60;
                String time=String.format("%d:%02d:%02d",hours,minutes,secs);
                timeView.setText(time);
                if(running)
                {
                    ++seconds;

                }
                handler.postDelayed(this,1000);

            }

        });


    }
}