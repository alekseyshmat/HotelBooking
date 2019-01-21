package exception;

/**
 * Designed for signal that service exception of some sort has occurred.
 */

public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
