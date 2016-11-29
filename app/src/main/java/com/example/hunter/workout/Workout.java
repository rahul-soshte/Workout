package com.example.hunter.workout;

/**
 * Created by hunter on 25/11/16.
 */

public class Workout {
private String name;
    private String description;

    public static final Workout[] workouts={
            new Workout("The Limb Loosener","5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Workout("Core Agony","100 Pull ups\n100 Push ups\n100 sit-ups\n100 Squats"),
            new Workout("The Wimp Special","5 Pull-ups\n10 Push-ups\n15 Squats"),
            new Workout("Strength and length","500 meter run\n21*1.5pood kettleball swing\n21*pull-ups")


    };
    //Each Workout has a name and description
    private Workout(String name,String description)
    {
        this.name=name;
        this.description=description;

    }
    public String getDescription()
    {
        return description;

    }
    public String getName()
    {
        return name;

    }
    public String toString()
    {
        return this.name;

    }

}


