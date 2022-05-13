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
    /**
     * Handles all API exceptions putting the appropriate body and status code into the response
     * @param ex an exception
     * @param request the upcoming request
     * @return a resulting response entity containing the exception body
     */
    @ExceptionHandler( ApiException.class )
    ResponseEntity<Object> handleApiException(ApiException ex, WebRequest request ) {
        return handleExceptionInternal( ex, ex.getBody(), new HttpHeaders(), ex.getStatus(), request );
    }
}
