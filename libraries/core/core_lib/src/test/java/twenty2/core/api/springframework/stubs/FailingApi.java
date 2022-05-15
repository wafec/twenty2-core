package twenty2.core.api.springframework.stubs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/failing-api" )
public class FailingApi {
    @GetMapping( "/hello" )
    public @ResponseBody String hello() throws AnyApiException {
        throw new AnyApiException();
    }
}
