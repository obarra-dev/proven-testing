```java
package com.example.springboot.poc.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Unit test cases for {@link ExampleEntity}
 */
// best practice: for performance reasons, we don't have to use any test runner
public class ExampleEntityTest {
    // best practice: declare common objects as class attributes (avoid duplicated code)
    private ExampleEntity exampleEntity;

    // best practice: initialize objects or mocks before each test execution
    @Before
    public void setup() {
        exampleEntity = new ExampleEntity();
    }

    // best practice: each unit test should include a scenario description: execution conditions and expected results
    // best practice: each unit test should have a descriptive name: method's name + conditions + should + expected result
    // advantages:
    // 1. creates unit test with similar format.
    // 2. helps to understand test logic.
    // 3. shows quickly what it should do and return without execute it.
    /**
     * Scenario:
     * Execute {@link ExampleEntity#setColumn1(String)}
     * with valid parameters.
     * Expectation:
     * After set the given value is returned.
     */
    @Test
    public void setGetColumn1() {
        // test assert: first of all, the attribute value should be null
        assertThat(exampleEntity.getColumn1(), nullValue());
        // set a value to tested attribute
        exampleEntity.setColumn1("someColumn1Value");
        // test assert: after set, attribute value shouldn't be null
        assertThat(exampleEntity, notNullValue());
        assertThat(exampleEntity.getColumn1(), equalTo("someColumn1Value"));
    }

    /**
     * Scenario:
     * Execute {@link ExampleEntity#setColumn2(String)}
     * with valid parameters.
     * Expectation:
     * After set the given value is returned.
     */
    @Test
    public void setGetColumn2() {
        // test assert: first of all, the attribute value should be null
        assertThat(exampleEntity.getColumn2(), nullValue());
        // set a value to tested attribute
        exampleEntity.setColumn2("someColumn2Value");
        // test assert: after set, attribute value shouldn't be null
        assertThat(exampleEntity, notNullValue());
        assertThat(exampleEntity.getColumn2(), equalTo("someColumn2Value"));
    }

    /**
     * Scenario:
     * Execute {@link ExampleEntity#setColumn3(String)}
     * with valid parameters.
     * Expectation:
     * After set the given value is returned.
     */
    @Test
    public void setGetColumn3() {
        // test assert: first of all, the attribute value should be null
        assertThat(exampleEntity.getColumn3(), nullValue());
        // set a value to tested attribute
        exampleEntity.setColumn3("someColumn3Value");
        // test assert: after set, attribute value shouldn't be null
        assertThat(exampleEntity, notNullValue());
        assertThat(exampleEntity.getColumn3(), equalTo("someColumn3Value"));
    }
}
```