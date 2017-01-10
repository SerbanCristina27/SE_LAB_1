package ro.mta.se.proiect.exceptions;

/**
 * Created by Cristina on 1/10/2017.
 */
public class ConnectionLostException extends Exception  {
    /**
     * exception message
     */
    static final String message = "Connection to server lost!";

    public ConnectionLostException() {
        super(message);
    }

    public ConnectionLostException(String message) {
        super(message);
    }

    public ConnectionLostException(Throwable cause) {
        super(cause);
    }

    public ConnectionLostException(String message, Throwable cause) {
        super(message, cause);
    }

}
