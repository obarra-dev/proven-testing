```java
package com.example.springboot.poc.service;

import com.example.springboot.poc.dao.ExampleDAO;
import com.example.springboot.poc.dao.ExampleDAOImpl;
import com.example.springboot.poc.dto.ExampleInfoRequestDTO;
import com.example.springboot.poc.dto.ExampleInfoResponseDTO;
import com.example.springboot.poc.entity.ExampleEntity;
import com.example.springboot.poc.validator.ExampleInfoRequestDTOValidator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.TransientDataAccessResourceException;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Unit test cases for {@link ExampleService}
 */
// best practice: for performance reasons, we don't have to use any test runner
public class ExampleServiceTest {
    @Rule //best practice: annotated objects at the begin of the class
    public ExpectedException thrown = ExpectedException.none();

    // best practice: declare common objects as class attributes (avoid duplicated code)
    private ExampleInfoRequestDTOValidator exampleInfoRequestDTOValidator;
    private ExampleDAO exampleDao; // best practice: use interfaces references
    private ExampleService exampleService;
    private ExampleInfoRequestDTO exampleInfoRequestDTO;

    // best practice: initialize objects or mocks before each test execution
    // best practice: mock common behavior here instead do that in each test
    @Before
    public void setup() {
        exampleDao = mock(ExampleDAOImpl.class); // mock dependency and if you need define the expected behavior
        exampleInfoRequestDTOValidator = mock(ExampleInfoRequestDTOValidator.class); // mock dependency and if you need define the expected behavior
        doNothing().when(exampleInfoRequestDTOValidator).validate(any(ExampleInfoRequestDTO.class)); // define expected behavior

        // create common request object for all tests with dummy values
        exampleInfoRequestDTO = new ExampleInfoRequestDTO("someValue", "123", "20000101");

        // best practice: use injection by constructor allows set mocks object
        exampleService = new ExampleService(exampleDao, exampleInfoRequestDTOValidator);
    }

    // best practice: each unit test should include a scenario description: execution conditions and expected results
    // best practice: each unit test should have a descriptive name: method's name + conditions + should + expected result
    // advantages:
    // 1. creates unit test with similar format.
    // 2. helps to understand test logic.
    // 3. shows quickly what it should do and return without execute it.
    /**
     * Scenario:
     * Execute {@link ExampleService#getExampleInfo(ExampleInfoRequestDTO)}
     * with valid parameters.
     * Expectation:
     * An {@link ExampleInfoResponseDTO} with valid values is returned.
     */
    @Test
    public void getExampleInfoWithValidParametersShouldReturnExampleInfoResponseDTO() {
        // best practice: use expected word for expected values of mocks
        // we define here because we expect different values in each test case
        ExampleInfoResponseDTO expectedExampleInfoResponseDTO = new ExampleInfoResponseDTO();
        expectedExampleInfoResponseDTO.setName("someName");
        expectedExampleInfoResponseDTO.setDescription("someDescription");

        ExampleEntity expectedExampleEntity = new ExampleEntity();
        expectedExampleEntity.setColumn1("someId");
        expectedExampleEntity.setColumn2("someName");
        expectedExampleEntity.setColumn3("someDescription");

        // we define the expected behavior of service here because it'll different in each test case
        // we expect those values as a result of service execution (invokes DAO twice)
        // we don't need any special value in request so we can use any matcher
        doReturn(expectedExampleEntity).when(exampleDao).getExampleInfo(any(ExampleInfoRequestDTO.class));
        doReturn(Arrays.asList(expectedExampleEntity)).when(exampleDao).getExampleInfoList(any(ExampleInfoRequestDTO.class));

        // we don't need set real values for request DTO because we've defined the behavior of validator class in setup method
        ExampleInfoResponseDTO result = exampleService.getExampleInfo(exampleInfoRequestDTO);

        // best practice: use hamcrest matchers: they're powerful and very descriptive
        // best practice: first of all: assert for the result to check if it's null
        assertThat(result, notNullValue());
        // test assert: expected attribute name
        assertThat(result.getName() , equalTo(expectedExampleInfoResponseDTO.getName()));
        // test assert: expected attribute name
        assertThat(result.getDescription() , equalTo(expectedExampleInfoResponseDTO.getDescription()));

        // best practice: verify if all mock methods have executed properly
        verify(exampleInfoRequestDTOValidator).validate(any(ExampleInfoRequestDTO.class));
        verify(exampleDao).getExampleInfo(any(ExampleInfoRequestDTO.class));
        verify(exampleDao).getExampleInfoList(any(ExampleInfoRequestDTO.class));
    }

    /**
     * Scenario:
     * Execute {@link ExampleService#getExampleInfo(ExampleInfoRequestDTO)}
     * with valid parameters and {@link ExampleDAO#getExampleInfoList(ExampleInfoRequestDTO)} throws an Exception.
     * Expectation:
     * A {@link DataAccessException} is thrown.
     */
    @Test
    public void getExampleInfoWithValidParametersAndGetExampleInfoListThrowsAnExceptionShouldThrowDataAccessException() {
        // best practice: expected exception should be first
        thrown.expect(DataAccessException.class);
        thrown.expectMessage("some exception");

        ExampleEntity expectedExampleEntity = new ExampleEntity();
        expectedExampleEntity.setColumn1("someId");
        expectedExampleEntity.setColumn2("someName");
        expectedExampleEntity.setColumn3("someDescription");

        // we define the expected behavior of service here because it'll different in each test case
        // we expect those values as a result of service execution (invokes DAO twice)
        // we don't need any special value in request so we can use any matcher
        doReturn(expectedExampleEntity).when(exampleDao).getExampleInfo(any(ExampleInfoRequestDTO.class));
        // we need an implementation of DataAccessException -> TransientDataAccessResourceException
        doThrow(new TransientDataAccessResourceException("some exception")).when(exampleDao).getExampleInfoList(any(ExampleInfoRequestDTO.class));

        // we don't need to mock or assert for anything else after exception
        exampleService.getExampleInfo(exampleInfoRequestDTO);

        // best practice: verify if all mock methods have executed properly
        verify(exampleInfoRequestDTOValidator).validate(any(ExampleInfoRequestDTO.class));
        verify(exampleDao).getExampleInfo(any(ExampleInfoRequestDTO.class));
        verify(exampleDao).getExampleInfoList(any(ExampleInfoRequestDTO.class));
    }

    /**
     * Scenario:
     * Execute {@link ExampleService#getExampleInfo(ExampleInfoRequestDTO)}
     * with valid parameters and {@link ExampleDAO#getExampleInfo(ExampleInfoRequestDTO)} throws an Exception.
     * Expectation:
     * A {@link DataAccessException} is thrown.
     */
    @Test
    public void getExampleInfoWithValidParametersAndGetExampleInfoThrowsAnExceptionShouldThrowDataAccessException() {
        // best practice: expected exception should be first
        thrown.expect(DataAccessException.class);
        thrown.expectMessage("some exception");

        ExampleEntity expectedExampleEntity = new ExampleEntity();
        expectedExampleEntity.setColumn1("someId");
        expectedExampleEntity.setColumn2("someName");
        expectedExampleEntity.setColumn3("someDescription");

        // we define the expected behavior of service here because it'll different in each test case
        // we expect those values as a result of service execution (invokes DAO twice)
        // we don't need any special value in request so we can use any matcher
        // we need an implementation of DataAccessException -> TransientDataAccessResourceException
        doThrow(new TransientDataAccessResourceException("some exception")).when(exampleDao).getExampleInfo(any(ExampleInfoRequestDTO.class));

        // we don't need to mock or assert for anything else after exception
        exampleService.getExampleInfo(exampleInfoRequestDTO);

        // best practice: verify if all mock methods have executed properly
        verify(exampleInfoRequestDTOValidator).validate(any(ExampleInfoRequestDTO.class));
        verify(exampleDao).getExampleInfo(any(ExampleInfoRequestDTO.class));
    }
}
```