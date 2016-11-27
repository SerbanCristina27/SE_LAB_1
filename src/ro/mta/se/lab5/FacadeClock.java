package ro.mta.se.lab5;

/**
 * Created by User on 11/26/2016.
 */
public class FacadeClock {
    public static Hours h = new Hours();
    public static Minutes m = new Minutes();
    public static Seconds s = new Seconds();



    public FacadeClock(){
        Timer instance = Timer.getInstance();

        instance.setH(h);
        instance.setM(m);
        instance.setS(s);

        instance.start();
    
    }

    public String GetDate(){
        return " " + h.getHour()  + " " + m.getMinutes() + " " + s.getSecond();
    }
}
