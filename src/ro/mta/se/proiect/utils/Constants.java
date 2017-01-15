package ro.mta.se.proiect.utils;

/**
 * Created by Cristina on 1/15/2017.
 */
public class Constants {

    /**
     * Global/app priority level
     */
    public static final String GLOBAL_LOG_LEVEL = "VERBOSE";
    public static final boolean DEBUG_MODE = false;

    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;

    public static final int SEND_MESSAGE = 1;
    public static final int RECEIVE_MESSAGE = 2;

    public enum Battlefield {

        planeHead,planeBody,empty

    }

    public interface LogLevel {

        String VERBOSE = "verbose";
        String DEBUG = "debug";
        String INFO = "info";
        String WARN = "warn";
        String ERROR = "error";

    }
    /**
     * Write to file
     */
    public static final boolean LOG_TO_FILE = true;

    /**
     * File name
     */
    public static final String LOG_FILE_NAME = "logger_file.log";
}
