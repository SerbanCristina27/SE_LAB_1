package ro.mta.se.lab5;

import java.util.Date;

/**
 * Created by User on 11/26/2016.
 */
public class Hours implements ITimeObserver {  //Class which computes Hours using the interface for clock listeners
    private int hour = 0;

    public int getHour() {
        return hour;
    }


        //This method updates every hour for the observer.
    @Override
    public void Update() {
        long yourMilliSeconds = System.currentTimeMillis();
        Date resultDate = new Date(yourMilliSeconds);
        hour = resultDate.getHours();
    }
}
