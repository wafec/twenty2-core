package twenty2.core.api.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestApiException extends AbstractGenericException {
    public BadRequestApiException( String message ) {
        this( message, null );
    }

    public BadRequestApiException( String message, Throwable throwable ) {
        super( message, throwable );
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
