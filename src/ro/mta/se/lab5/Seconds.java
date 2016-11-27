package ro.mta.se.lab5;

import java.util.Date;

/**
 * Created by User on 11/26/2016.
 */
public class Seconds implements ITimeObserver { //Class which computes Seconds using the interface for clock listeners
    private int second = 0;

    public int getSecond() {
        return second;
    }

    //This method updates every second for the observer.
    @Override
    public void Update() {
        long yourMilliSeconds = System.currentTimeMillis();
        Date resultDate = new Date(yourMilliSeconds);
        second = resultDate.getSeconds();
    }
}
