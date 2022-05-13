package twenty2.commons.api.exceptions;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends Exception {
    /**
     * Returns the body of the request
     * @param <T> a generic body type
     * @return the body object
     */
    public abstract <T> T getBody();

    /**
     * Returns the status of the request
     * @return an HttpStatus enum value
     */
    public abstract HttpStatus getStatus();
}
