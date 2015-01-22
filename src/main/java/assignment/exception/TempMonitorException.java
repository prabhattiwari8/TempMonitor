package assignment.exception;

/**
 * Created by cwr.prabhat.tiwari on 1/19/15.
 */


public class TempMonitorException extends Exception {
    public TempMonitorException(String message) {
        super(message);
    }

    public TempMonitorException(String message, Throwable cause) {
        super(message, cause);
    }
}

