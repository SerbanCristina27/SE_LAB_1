package ro.mta.se.proiect.exceptions;

/**
 * Created by Cristina on 1/10/2017.
 */
public class BattlefieldIsEmptyException extends Exception {

    /**
     * exception message
     */
    static final String message = "Battlefield is empty!";


    public BattlefieldIsEmptyException(){ super(message);}

    public BattlefieldIsEmptyException(String message){super(message);}

    public BattlefieldIsEmptyException(Throwable cause) {
        super(cause);
    }

    public BattlefieldIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }


}
