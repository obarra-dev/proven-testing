package com.example.springboot.poc.message;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Unit test cases for {@link ExampleMessage}
 */
// best practice: for performance reasons, we don't have to use any test runner
public class ExampleMessageTest {

    // best practice: each unit test should include a scenario description: execution conditions and expected results
    // best practice: each unit test should have a descriptive name: method's name + conditions + should + expected result
    // advantages:
    // 1. creates unit test with similar format.
    // 2. helps to understand test logic.
    // 3. shows quickly what it should do and return without execute it.
    /**
     * Scenario:
     * Execute {@link ExampleMessage#getMessage()}.
     * Expectation:
     * A proper message.
     */
    @Test
    public void getMessageShouldReturnProperMessage() {
        // best practice: use hamcrest matchers: they're powerful and very descriptive
        assertThat(ExampleMessage.EXAMPLE_STATUS_OK.getMessage(), equalTo("OK"));
        assertThat(ExampleMessage.EXAMPLE_STATUS_ERROR.getMessage(), equalTo("ERROR"));
        assertThat(ExampleMessage.EXAMPLE_INFO_REQUEST_CAN_NOT_BE_NULL.getMessage(), equalTo("The request cannot be null"));
        assertThat(ExampleMessage.EXAMPLE_INFO_PARAMETER_1_CAN_NOT_BE_NULL.getMessage(), equalTo("The parameter 1 cannot be null"));
        assertThat(ExampleMessage.EXAMPLE_INFO_PARAMETER_2_CAN_NOT_BE_EMPTY.getMessage(), equalTo("The parameter 2 cannot be null or empty"));
        assertThat(ExampleMessage.EXAMPLE_INFO_PARAMETER_2_SHOULD_BE_NUMERIC.getMessage(), equalTo("The parameter 2 should be a number"));
        assertThat(ExampleMessage.EXAMPLE_INFO_PARAMETER_3_CAN_NOT_BE_EMPTY.getMessage(), equalTo("The parameter 3 cannot be null or empty"));
        assertThat(ExampleMessage.EXAMPLE_INFO_PARAMETER_3_FORMAT_SHOULD_BE_YYYYMMDD.getMessage(), equalTo("The parameter 3 should be in YYYYMMDD format"));
    }
}
