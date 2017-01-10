package ro.mta.se.proiect.exceptions;

/**
 * Created by Cristina on 1/10/2017.
 */
public class ConnectToServerException extends Exception {
    /**
     * exception message
     */
    static final String message = "Cannot connect to server!";

    public ConnectToServerException() {
        super(message);
    }

    public ConnectToServerException(String message) {
        super(message);
    }

    public ConnectToServerException(Throwable cause) {
        super(cause);
    }

    public ConnectToServerException(String message, Throwable cause) {
        super(message, cause);
    }

}
