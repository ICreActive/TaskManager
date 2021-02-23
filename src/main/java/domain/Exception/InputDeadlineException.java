package domain.Exception;

import java.util.InputMismatchException;

public class InputDeadlineException extends Exception {

    public InputDeadlineException() {
        super();
    }

    public InputDeadlineException(String message) {
        super(message);
    }

    public InputDeadlineException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputDeadlineException(Throwable cause) {
        super(cause);
    }

    protected InputDeadlineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}