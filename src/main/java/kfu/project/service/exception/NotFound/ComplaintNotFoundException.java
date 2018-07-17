package kfu.project.service.exception.NotFound;

/**
 * Created by Nurislam on 27.03.2018.
 */
public class ComplaintNotFoundException extends Exception {
    public ComplaintNotFoundException() {
        super();
    }

    public ComplaintNotFoundException(String message) {
        super(message);
    }

    public ComplaintNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComplaintNotFoundException(Throwable cause) {
        super(cause);
    }
}
