package twenty2.commons.api.exceptions;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends Exception {
    public abstract <T> T getBody();
    public abstract HttpStatus getStatus();
}
