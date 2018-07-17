package kfu.project.service.exception.NotFound;

/**
 * Created by Nurislam on 19.12.2017.
 */
public class EventNotFoundException extends Exception{
    public EventNotFoundException() {
    }

    public EventNotFoundException(String message) {
        super(message);
    }

    public EventNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventNotFoundException(Throwable cause) {
        super(cause);
    }
}
