
package com.example.springboot.poc.controller;

import com.example.springboot.poc.dto.ExampleErrorResponseDTO;
import com.example.springboot.poc.dto.ExampleInfoRequestDTO;
import com.example.springboot.poc.dto.ExampleInfoResponseDTO;
import com.example.springboot.poc.message.ExampleMessage;
import com.example.springboot.poc.service.ExampleService;
import com.example.springboot.poc.validator.ExampleInfoRequestDTOValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Unit test cases for {@link ExampleController}
 */
// best practice: for performance reasons, we don't have to use any test runner
public class ExampleControllerTest {

    // best practice: declare common objects as class attributes (avoid duplicate code)
    private ExampleInfoRequestDTOValidator exampleInfoRequestDTOValidator;
    private ExampleService exampleService;
    private ExampleController exampleController;
    private ExampleInfoRequestDTO exampleInfoRequestDTO;

    // best practice: initialize objects or mocks before each test execution
    // best practice: mock common behavior here instead do that in each test
    @Before
    public void setup() {
        exampleService = mock(ExampleService.class); // mock dependency and if you need define the expected behavior
        exampleInfoRequestDTOValidator = mock(ExampleInfoRequestDTOValidator.class); // mock dependency and if you need define the expected behavior
        doNothing().when(exampleInfoRequestDTOValidator).validate(any(ExampleInfoRequestDTO.class)); // define expected behavior

        // create common request object for all tests with dummy values
        exampleInfoRequestDTO = new ExampleInfoRequestDTO("someValue", "123", "20000101");

        // best practice: use injection by constructor allows set mocks object
        exampleController = new ExampleController(exampleService, exampleInfoRequestDTOValidator);
    }

    // best practice: each unit test should include a scenario description: execution conditions and expected results
    // best practice: each unit test should have a descriptive name: method's name + conditions + should + expected result
    // advantages:
    // 1. creates unit test with similar format.
    // 2. helps to understand test logic.
    // 3. shows quickly what it should do and return without execute it.
    /**
     * Scenario:
     * Execute {@link ExampleController#getExampleInfo(ExampleInfoRequestDTO)}
     * with valid parameters.
     * Expectation:
     * A {@link ResponseEntity} with HTTP Status OK (200) and a valid {@link ExampleInfoResponseDTO}
     * as body are returned.
     */
    @Test
    public void getExampleInfoWithValidParametersShouldReturnOkHttpStatusAndExampleInfoResponseDTO() {
        // best practice: use expected word for expected values of mocks
        // we define here because we expect different values in each test case
        ExampleInfoResponseDTO expectedExampleInfoResponseDTO = new ExampleInfoResponseDTO();
        expectedExampleInfoResponseDTO.setName("someName");
        expectedExampleInfoResponseDTO.setDescription("someDescription");

        // we define the expected behavior of service here because it'll different in each test case
        // we expect that value as a result of service execution
        // we don't need any special value in request so we can use any matcher
        doReturn(expectedExampleInfoResponseDTO).when(exampleService).getExampleInfo(any(ExampleInfoRequestDTO.class));

        // we don't need set real values for request DTO because we've defined the behavior of validator class in setup method
        ResponseEntity result = exampleController.getExampleInfo(exampleInfoRequestDTO);

        // best practice: use hamcrest matchers: they're powerful and very descriptive
        // best practice: first of all: assert for the result to check if it's null
        assertThat(result, notNullValue());
        // test assert: expected http status
        assertThat(result.getStatusCodeValue(), equalTo(HttpStatus.OK.value()));
        // test assert: body not null
        assertThat(result.getBody(), notNullValue());
        // test assert: expected response class
        assertThat(result.getBody().getClass() , equalTo(ExampleInfoResponseDTO.class));
        // test assert: expected attribute name
        assertThat(((ExampleInfoResponseDTO)result.getBody()).getName() , equalTo(expectedExampleInfoResponseDTO.getName()));
        // test assert: expected attribute name
        assertThat(((ExampleInfoResponseDTO)result.getBody()).getDescription() , equalTo(expectedExampleInfoResponseDTO.getDescription()));

        // best practice: verify if all mock methods have executed properly
        verify(exampleInfoRequestDTOValidator).validate(any(ExampleInfoRequestDTO.class));
        verify(exampleService).getExampleInfo(any(ExampleInfoRequestDTO.class));
    }

    /**
     * Scenario:
     * Execute {@link ExampleController#getExampleInfo(ExampleInfoRequestDTO)}
     * with valid parameters and {@link ExampleService} throws a {@link RuntimeException}.
     * Expectation:
     * A {@link ResponseEntity} with HTTP Status Internal Server Error (500) and a valid {@link ExampleErrorResponseDTO}
     * as body are returned.
     */
    @Test
    public void getExampleInfoWithValidParametersAndExampleServiceThrowsAnExceptionShouldReturn500HttpStatusAndExampleErrorResponseDTO() {
        ExampleErrorResponseDTO expectedExampleErrorResponseDTO = new ExampleErrorResponseDTO();
        expectedExampleErrorResponseDTO.setStatus(ExampleMessage.EXAMPLE_STATUS_ERROR.getMessage());
        expectedExampleErrorResponseDTO.setMessage("someErrorMessage");

        // we define the expected behavior of service here because it'll different in each test case
        // we expect that value as a result of service execution
        // we don't need any special value in request so we can use any matcher
        doThrow(new RuntimeException("someErrorMessage")).when(exampleService).getExampleInfo(any(ExampleInfoRequestDTO.class));

        ResponseEntity result = exampleController.getExampleInfo(exampleInfoRequestDTO);

        assertThat(result, notNullValue());
        assertThat(result.getStatusCodeValue(), equalTo(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        assertThat(result.getBody(), notNullValue());
        assertThat(result.getBody().getClass() , equalTo(ExampleErrorResponseDTO.class));
        assertThat(((ExampleErrorResponseDTO)result.getBody()).getStatus() , equalTo(expectedExampleErrorResponseDTO.getStatus()));
        assertThat(((ExampleErrorResponseDTO)result.getBody()).getMessage() , equalTo(expectedExampleErrorResponseDTO.getMessage()));

        verify(exampleInfoRequestDTOValidator).validate(any(ExampleInfoRequestDTO.class));
        verify(exampleService).getExampleInfo(any(ExampleInfoRequestDTO.class));
    }
}
