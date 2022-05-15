package twenty2.core.api.springframework;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import twenty2.core.api.springframework.stubs.AnyApiException;
import twenty2.core.api.springframework.stubs.FailingApi;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith( SpringExtension.class )
@SpringBootTest( webEnvironment = WebEnvironment.MOCK, classes = { FailingApi.class, RestResponseEntityExceptionHandler.class } )
@AutoConfigureMockMvc
public class RestResponseEntityExceptionHandlerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() throws Exception {
        ResultActions result = mvc.perform( get("/failing-api/hello") );

        result
                .andExpect( status().isBadRequest() )
                .andExpect( jsonPath( "$.message", is( AnyApiException.MESSAGE ) ) );
    }
}
