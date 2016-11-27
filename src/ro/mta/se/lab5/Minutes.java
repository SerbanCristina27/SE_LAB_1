package ro.mta.se.lab5;

import java.util.Date;

/**
 * Created by User on 11/26/2016.
 */
public class Minutes implements ITimeObserver{  //Class which computes Minutes using the interface for clock listeners
    private int minutes = 0;

    public int getMinutes() {
        return minutes;
    }

    //This method updates every minute for the observer.
    @Override
    public void Update() {
        long yourMilliSeconds = System.currentTimeMillis();
        Date resultDate = new Date(yourMilliSeconds);
        minutes = resultDate.getMinutes();
    }
}
