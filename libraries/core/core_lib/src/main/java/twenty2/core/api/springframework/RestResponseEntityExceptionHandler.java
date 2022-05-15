package twenty2.core.api.springframework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import twenty2.core.api.exceptions.AbstractApiException;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * Handles all API exceptions putting the appropriate body and status code into the response
     * @param ex an exception
     * @param request the upcoming request
     * @return a resulting response entity containing the exception body
     */
    @ExceptionHandler( AbstractApiException.class )
    ResponseEntity<Object> handleApiException(AbstractApiException ex, WebRequest request ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_JSON );
        String body = objectMapper.writeValueAsString( ex.getBody() );
        return handleExceptionInternal(ex, body, headers, ex.getStatus(), request );
    }
}
