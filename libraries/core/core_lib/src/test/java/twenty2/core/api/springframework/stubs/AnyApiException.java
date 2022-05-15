package twenty2.core.api.springframework.stubs;

import org.springframework.http.HttpStatus;
import twenty2.core.api.exceptions.AbstractApiException;

public class AnyApiException extends AbstractApiException {
    public static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
    public static final String MESSAGE = "Any exception message";

    @Override
    public Object getBody() {
        return new AnyExceptionBody( STATUS.value(), MESSAGE );
    }

    @Override
    public HttpStatus getStatus() {
        return STATUS;
    }
}
