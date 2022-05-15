package twenty2.core.api.springframework.stubs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnyExceptionBody {
    private int statusCode;
    private String message;
}
