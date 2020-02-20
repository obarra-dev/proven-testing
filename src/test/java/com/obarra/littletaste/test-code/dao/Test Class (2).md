```java
package com.example.springboot.poc.dao;

import com.example.springboot.poc.dao.mapper.ExampleInfoMapper;
import com.example.springboot.poc.dto.ExampleInfoRequestDTO;
import com.example.springboot.poc.entity.ExampleEntity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Unit test cases for {@link ExampleDAOImpl}
 */
// best practice: for performance reasons, we don't have to use any test runner
public class ExampleDAOImplTest {
    @Rule //best practice: annotated objects at the begin of the class
    public ExpectedException thrown = ExpectedException.none();

    // best practice: declare common objects as class attributes (avoid duplicated code)
    private JdbcTemplate jdbcTemplate;
    private ExampleDAO exampleDAO;
    private ExampleInfoRequestDTO exampleInfoRequestDTO;

    // best practice: initialize objects or mocks before each test execution
    // best practice: mock common behavior here instead do that in each test
    @Before
    public void setup() {
        jdbcTemplate = mock(JdbcTemplate.class); // mock dependency and if you need define the expected behavior

        // create common request object for all tests with dummy values
        exampleInfoRequestDTO = new ExampleInfoRequestDTO("someValue", "123", "20000101");

        // best practice: use injection by constructor allows set mocks object
        exampleDAO = new ExampleDAOImpl(jdbcTemplate);
    }

    // best practice: each unit test should include a scenario description: execution conditions and expected results
    // best practice: each unit test should have a descriptive name: method's name + conditions + should + expected result
    // advantages:
    // 1. creates unit test with similar format.
    // 2. helps to understand test logic.
    // 3. shows quickly what it should do and return without execute it.
    /**
     * Scenario:
     * Execute {@link ExampleDAOImpl#getExampleInfo(ExampleInfoRequestDTO)}
     * with valid parameters.
     * Expectation:
     * An {@link ExampleEntity} with valid values is returned.
     */
    @Test
    public void getExampleInfoWithValidParametersShouldReturnExampleEntity() {
        // best practice: use expected word for expected values of mocks
        // we define here because we expect different values in each test case
        ExampleEntity expectedExampleEntity = new ExampleEntity();
        expectedExampleEntity.setColumn1("someId");
        expectedExampleEntity.setColumn2("someName");
        expectedExampleEntity.setColumn3("someDescription");

        // we define the expected behavior of service here because it'll different in each test case
        // we expect those values as a result of service execution (invokes DAO twice)
        // we don't need any special value in request so we can use any matcher
        doReturn(Arrays.asList(expectedExampleEntity)).when(jdbcTemplate).query(anyString(), any(Object[].class), any(ExampleInfoMapper.class)); // define expected behavior

        // we don't need set real values for request DTO because we've defined the behavior of validator class in setup method
        ExampleEntity result = exampleDAO.getExampleInfo(exampleInfoRequestDTO);

        // best practice: use hamcrest matchers: they're powerful and very descriptive
        // best practice: first of all: assert for the result to check if it's null
        assertThat(result, notNullValue());
        // test assert: expected attribute column 1, 2 and 3
        assertThat(result.getColumn1() , equalTo(expectedExampleEntity.getColumn1()));
        assertThat(result.getColumn2() , equalTo(expectedExampleEntity.getColumn2()));
        assertThat(result.getColumn3() , equalTo(expectedExampleEntity.getColumn3()));

        // best practice: verify if all mock methods have executed properly
        verify(jdbcTemplate).query(anyString(), any(Object[].class), any(ExampleInfoMapper.class));
    }

    /**
     * Scenario:
     * Execute {@link ExampleDAOImpl#getExampleInfo(ExampleInfoRequestDTO)}
     * with valid parameters and {@link JdbcTemplate#query(String, Object[], RowMapper)} throws
     * a {@link DataAccessException}.
     * Expectation:
     * An {@link ExampleEntity} with valid values is returned.
     */
    @Test
    public void getExampleInfoWithValidParametersAndJdbcTemplateThrowsDataAccessExceptionShouldThrowDataAccessException() {
        // best practice: expected exception should be first
        thrown.expect(DataAccessException.class);
        thrown.expectMessage("some exception");

        // we define the expected behavior of service here because it'll different in each test case
        // we don't need any special value in request so we can use any matcher
        // we need an implementation of DataAccessException -> TransientDataAccessResourceException
        doThrow(new TransientDataAccessResourceException("some exception")).when(jdbcTemplate).query(anyString(), any(Object[].class), any(ExampleInfoMapper.class)); // define expected behavior

        // we don't need to mock or assert for anything else after exception
        exampleDAO.getExampleInfo(exampleInfoRequestDTO);

        // best practice: verify if all mock methods have executed properly
        verify(jdbcTemplate).query(anyString(), any(Object[].class), any(ExampleInfoMapper.class));
    }

    /**
     * Scenario:
     * Execute {@link ExampleDAOImpl#getExampleInfoList(ExampleInfoRequestDTO)}
     * with valid parameters.
     * Expectation:
     * A {@link List} of {@link ExampleEntity} with valid values is returned.
     */
    @Test
    public void getExampleInfoListWithValidParametersShouldReturnExampleEntityList() {
        // best practice: use expected word for expected values of mocks
        // we define here because we expect different values in each test case
        ExampleEntity expectedExampleEntity1 = new ExampleEntity();
        expectedExampleEntity1.setColumn1("someId1");
        expectedExampleEntity1.setColumn2("someName1");
        expectedExampleEntity1.setColumn3("someDescription1");
        ExampleEntity expectedExampleEntity2 = new ExampleEntity();
        expectedExampleEntity2.setColumn1("someId2");
        expectedExampleEntity2.setColumn2("someName2");
        expectedExampleEntity2.setColumn3("someDescription1");

        List<ExampleEntity> exampleEntityList = Arrays.asList(expectedExampleEntity1, expectedExampleEntity2);

        // we define the expected behavior of service here because it'll different in each test case
        // we expect those values as a result of service execution (invokes DAO twice)
        // we don't need any special value in request so we can use any matcher
        doReturn(exampleEntityList).when(jdbcTemplate).query(anyString(), any(Object[].class), any(ExampleInfoMapper.class)); // define expected behavior

        // we don't need set real values for request DTO because we've defined the behavior of validator class in setup method
        List<ExampleEntity> result = exampleDAO.getExampleInfoList(exampleInfoRequestDTO);

        // best practice: use hamcrest matchers: they're powerful and very descriptive
        // best practice: first of all: assert for the result to check if it's null
        assertThat(result, notNullValue());
        // test assert: expected size
        assertThat(result.size() , equalTo(exampleEntityList.size()));
        // test assert: expected attribute column 1, 2 and 3
        assertThat(result.get(0).getColumn1() , equalTo(exampleEntityList.get(0).getColumn1()));
        assertThat(result.get(0).getColumn2() , equalTo(exampleEntityList.get(0).getColumn2()));
        assertThat(result.get(0).getColumn3() , equalTo(exampleEntityList.get(0).getColumn3()));
        assertThat(result.get(1).getColumn1() , equalTo(exampleEntityList.get(1).getColumn1()));
        assertThat(result.get(1).getColumn2() , equalTo(exampleEntityList.get(1).getColumn2()));
        assertThat(result.get(1).getColumn3() , equalTo(exampleEntityList.get(1).getColumn3()));

        // best practice: verify if all mock methods have executed properly
        verify(jdbcTemplate).query(anyString(), any(Object[].class), any(ExampleInfoMapper.class));
    }

    /**
     * Scenario:
     * Execute {@link ExampleDAOImpl#getExampleInfoList(ExampleInfoRequestDTO)}
     * with valid parameters and {@link JdbcTemplate#query(String, Object[], RowMapper)} throws
     * a {@link DataAccessException}.
     * Expectation:
     * An {@link ExampleEntity} with valid values is returned.
     */
    @Test
    public void getExampleInfoListWithValidParametersAndJdbcTemplateThrowsDataAccessExceptionShouldThrowDataAccessException() {
        // best practice: expected exception should be first
        thrown.expect(DataAccessException.class);
        thrown.expectMessage("some exception");

        // we define the expected behavior of service here because it'll different in each test case
        // we don't need any special value in request so we can use any matcher
        // we need an implementation of DataAccessException -> TransientDataAccessResourceException
        doThrow(new TransientDataAccessResourceException("some exception")).when(jdbcTemplate).query(anyString(), any(Object[].class), any(ExampleInfoMapper.class)); // define expected behavior

        // we don't need to mock or assert for anything else after exception
        exampleDAO.getExampleInfoList(exampleInfoRequestDTO);

        // best practice: verify if all mock methods have executed properly
        verify(jdbcTemplate).query(anyString(), any(Object[].class), any(ExampleInfoMapper.class));
    }
}
```