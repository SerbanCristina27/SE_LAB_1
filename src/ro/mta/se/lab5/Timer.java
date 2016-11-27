package ro.mta.se.lab5;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by User on 11/26/2016.
 */
public class Timer extends Thread {
    private static Timer instance; // Singleton
    private static boolean started = false;
    private Hours h = null;
    private Seconds s = null;
    private Minutes m = null;
    private List<ITimeObserver> Listeners = new ArrayList<>(); // List of all observers

    protected Timer() {

    }

    public static Timer getInstance() {  //This method instantiates only once the timer property.
        if (instance == null) {
            instance = new Timer();
        }
        return instance;

    }

    //This method will run the clock
    public void run() {
        if (!started) {
            started = true;
            while (true) {
                try {
                    Thread.sleep(1000);
                    h.Update();
                    m.Update();
                    s.Update();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }

    public void setH(Hours hh) {
        this.h = hh;
    } //Set the hour for the clock

    public void setM(Minutes mm) {
        this.m = mm;
    } //Set the minute for the clock

    public void setS(Seconds ss) {
        this.s = ss;
    } //Set the second for the clock

    public void attach(ITimeObserver listener) {
        if (Listeners.contains(listener)) {
            System.out.println("Listener already attached!");
            return;
        }
        Listeners.add(listener);
    }

    public void detach(ITimeObserver listener) {
        if (!Listeners.contains(listener)) {
            System.out.println("Listener already detached!");
            return;
        }
        Listeners.remove(listener);
    }




}
