```java
package com.example.springboot.poc.dao.mapper;

import com.example.springboot.poc.entity.ExampleEntity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Unit test cases for {@link ExampleInfoMapper}
 */
// best practice: for performance reasons, we don't have to use any test runner
public class ExampleInfoMapperTest {
    @Rule //best practice: annotated objects at the begin of the class
    public ExpectedException thrown = ExpectedException.none();

    // best practice: declare common objects as class attributes (avoid duplicated code)
    private ResultSet resultSet;
    private ExampleInfoMapper exampleInfoMapper;

    // best practice: initialize objects or mocks before each test execution
    @Before
    public void setup() {
        resultSet = mock(ResultSet.class);
        exampleInfoMapper = new ExampleInfoMapper();
    }

    // best practice: each unit test should include a scenario description: execution conditions and expected results
    // best practice: each unit test should have a descriptive name: method's name + conditions + should + expected result
    // advantages:
    // 1. creates unit test with similar format.
    // 2. helps to understand test logic.
    // 3. shows quickly what it should do and return without execute it.
    /**
     * Scenario:
     * Execute {@link ExampleInfoMapper#mapRow(ResultSet, int)}
     * with valid parameters.
     * Expectation:
     * A {@link ExampleEntity} is returned.
     */
    @Test
    public void mapRowWithValidParametersShouldReturnValidExampleEntity() throws Exception {
        // we have to mock any interaction of class with ResultSet object (in this example 3 times)
        doReturn("someCol2").when(resultSet).getString(anyString());

        // you can repeat each interaction:
        //   doReturn("someCol1").when(resultSet).getString(anyInt());
        //   doReturn("someCol3").when(resultSet).getString(anyInt());
        // or you can chain "doReturn" interaction for the same "when" logic
        doReturn("someCol1").doReturn("someCol3").when(resultSet).getString(anyInt());

        // invoke real method (subject of test case)
        ExampleEntity result = exampleInfoMapper.mapRow(resultSet, 0);

        // best practice: use hamcrest matchers: they're powerful and very descriptive
        // best practice: first of all: assert for the result to check if it's null
        assertThat(result, notNullValue());
        // test assert: expected entity's attributes
        assertThat(result.getColumn1() , equalTo("someCol1"));
        assertThat(result.getColumn2() , equalTo("someCol2"));
        assertThat(result.getColumn3() , equalTo("someCol3"));

        // best practice: verify if all mock methods have executed properly
        verify(resultSet).getString(anyString());
        verify(resultSet, times(2)).getString(anyInt());
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoMapper#mapRow(ResultSet, int)}
     * with valid parameters and {@link ResultSet} throws a exception.
     * Expectation:
     * A {@link SQLException} is thrown.
     */
    @Test
    public void mapRowWithValidParametersAndGetColumn3ThrowsSQLExceptionShouldThrowSQLException() throws Exception {
        // best practice: expected exception should be first
        thrown.expect(SQLException.class);
        thrown.expectMessage("some exception");

        // we have to mock any interaction of class with ResultSet object (in this example 3 times)
        doReturn("someCol2").when(resultSet).getString(anyString());

        // chain "doReturn" and "doThrow" interaction for the same "when" logic
        doReturn("someCol1").doThrow(new SQLException("some exception")).when(resultSet).getString(anyInt());

        // we don't need to mock or assert for anything else after exception
        exampleInfoMapper.mapRow(resultSet, 0);

        // best practice: verify if all mock methods have executed properly
        verify(resultSet).getString(anyString());
        verify(resultSet, times(2)).getString(anyInt());
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoMapper#mapRow(ResultSet, int)}
     * with valid parameters and {@link ResultSet} throws a exception.
     * Expectation:
     * A {@link SQLException} is thrown.
     */
    @Test
    public void mapRowWithValidParametersAndGetColumn2ThrowsSQLExceptionShouldThrowSQLException() throws Exception {
        // best practice: expected exception should be first
        thrown.expect(SQLException.class);
        thrown.expectMessage("some exception");

        // we don't have chain because we have two different calls
        doReturn("someCol1").when(resultSet).getString(anyInt());
        doThrow(new SQLException("some exception")).when(resultSet).getString(anyString());

        // we don't need to mock or assert for anything else after exception
        exampleInfoMapper.mapRow(resultSet, 0);

        // best practice: verify if all mock methods have executed properly
        verify(resultSet).getString(anyInt());
        verify(resultSet).getString(anyString());
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoMapper#mapRow(ResultSet, int)}
     * with valid parameters and {@link ResultSet} throws a exception.
     * Expectation:
     * A {@link SQLException} is thrown.
     */
    @Test
    public void mapRowWithValidParametersAndGetColumn1ThrowsSQLExceptionShouldThrowSQLException() throws Exception {
        // best practice: expected exception should be first
        thrown.expect(SQLException.class);
        thrown.expectMessage("some exception");

        // we dont have any chain because it'll fail in first getString execution
        doThrow(new SQLException("some exception")).when(resultSet).getString(anyInt());

        // we don't need to mock or assert for anything else after exception
        exampleInfoMapper.mapRow(resultSet, 0);

        // best practice: verify if all mock methods have executed properly
        verify(resultSet).getString(anyInt());
    }
}
```