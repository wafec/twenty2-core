package twenty2.core.api.exceptions;

import org.springframework.http.HttpStatus;

public abstract class AbstractApiException extends Exception {
    /**
     * Returns the body of the request
     * @return the body object
     */
    public abstract Object getBody();

    /**
     * Returns the status of the request
     * @return an HttpStatus enum value
     */
    public abstract HttpStatus getStatus();
}
