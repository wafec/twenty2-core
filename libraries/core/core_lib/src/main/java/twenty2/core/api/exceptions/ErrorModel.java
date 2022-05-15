package twenty2.core.api.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class ErrorModel {
    private String message;
    private Map<String, String> errors;
    private Object exception;
}
