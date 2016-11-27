package ro.mta.se.lab5;

/**
 * Created by User on 11/26/2016.
 */
public class Main {
    public static void main(String[] args) {
        FacadeClock c = new FacadeClock();

        for(;;){
            System.out.println(c.GetDate());
            try{
                Thread.sleep(1000);

            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }

    }
}
