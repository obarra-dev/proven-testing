```java
package com.example.springboot.poc.service;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
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
import org.mockito.ArgumentCaptor;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Unit test cases for {@link ExampleService}
 */
// best practice: for performance reasons, we don't have to use any test runner
public class ExampleServiceLoggerTest {
    @Rule //best practice: annotated objects at the begin of the class
    public ExpectedException thrown = ExpectedException.none();

    // best practice: declare common objects as class attributes (avoid duplicated code)
    private ExampleInfoRequestDTOValidator exampleInfoRequestDTOValidator;
    private ExampleDAO exampleDao; // best practice: use interfaces references
    private ExampleService exampleService;
    private Appender appender;
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

        // appender for log
        appender = mock(Appender.class);
        ((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).addAppender(appender);

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
        exampleService.getExampleInfo(exampleInfoRequestDTO);

        // instead assertions over result we'll assert over mocked logger - only for example purposes
        ArgumentCaptor<Appender> argumentCaptor = ArgumentCaptor.forClass(Appender.class);
        verify(appender, times(7)).doAppend(argumentCaptor.capture());

        // assert for expected number of log lines (INFO and DEBUG)
        assertThat(argumentCaptor.getAllValues().size(), equalTo(7));
        assertThat(((LoggingEvent)argumentCaptor.getAllValues().get(5)).getMessage(), equalTo("getExampleInfo - exampleInfo element - col 1: {}"));
        assertThat(((LoggingEvent)argumentCaptor.getAllValues().get(6)).getMessage(), containsString("getExampleInfo - exampleInfo element - col 2"));

        // best practice: verify if all mock methods have executed properly
        verify(exampleInfoRequestDTOValidator).validate(any(ExampleInfoRequestDTO.class));
        verify(exampleDao).getExampleInfo(any(ExampleInfoRequestDTO.class));
        verify(exampleDao).getExampleInfoList(any(ExampleInfoRequestDTO.class));
    }
}
```