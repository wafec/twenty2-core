package twenty2.commons.api.spring;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import twenty2.commons.api.exceptions.ApiException;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler( ApiException.class )
    ResponseEntity<Object> handleApiException(ApiException ex, WebRequest request ) {
        return handleExceptionInternal( ex, ex.getBody(), new HttpHeaders(), ex.getStatus(), request );
    }
}
