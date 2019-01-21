package exception;

/**
 * Designed for signal that an database access object exception of some sort has occurred.
 */

public class RepositoryException extends Exception {
    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
