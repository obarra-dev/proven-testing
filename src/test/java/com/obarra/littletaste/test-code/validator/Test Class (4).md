```java
package com.example.springboot.poc.validator;

import com.example.springboot.poc.dto.ExampleInfoRequestDTO;
import com.example.springboot.poc.message.ExampleMessage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test cases for {@link ExampleInfoRequestDTOValidator}
 */
// best practice: for performance reasons, we don't have to use any test runner
public class ExampleInfoRequestDTOValidatorTest {
    @Rule //best practice: annotated objects at the begin of the class
    public ExpectedException thrown = ExpectedException.none();

    // best practice: declare common objects as class attributes (avoid duplicated code)
    private ExampleInfoRequestDTOValidator exampleInfoRequestDTOValidator;
    private ExampleInfoRequestDTO exampleInfoRequestDTO;
    // best practice: initialize objects or mocks before each test execution
    @Before
    public void setup() {
        exampleInfoRequestDTO = new ExampleInfoRequestDTO("some value", "1234", "20100101");
        exampleInfoRequestDTOValidator = new ExampleInfoRequestDTOValidator();
    }

    // best practice: each unit test should include a scenario description: execution conditions and expected results
    // best practice: each unit test should have a descriptive name: method's name + conditions + should + expected result
    // advantages:
    // 1. creates unit test with similar format.
    // 2. helps to understand test logic.
    // 3. shows quickly what it should do and return without execute it.
    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with a valid {@link ExampleInfoRequestDTO}.
     * Expectation:
     * The {@link ExampleInfoRequestDTO} should be validate without throws any exception.
     */
    @Test
    public void validateWithValidParametersShouldNotThrownAnyException() {
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with a null {@link ExampleInfoRequestDTO}.
     * Expectation:
     * A {@link NullPointerException} is thrown.
     */
    @Test
    public void validateWithNullParametersShouldThrowNullPointerException() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(ExampleMessage.EXAMPLE_INFO_REQUEST_CAN_NOT_BE_NULL.getMessage());
        exampleInfoRequestDTOValidator.validate(null);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with a null parameter 1.
     * Expectation:
     * A {@link NullPointerException} is thrown.
     */
    @Test
    public void validateWithNullParameter1ShouldThrowNullPointerException() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(ExampleMessage.EXAMPLE_INFO_PARAMETER_1_CAN_NOT_BE_NULL.getMessage());

        exampleInfoRequestDTO.setParameter1(null);
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with an empty parameter 1.
     * Expectation:
     * The {@link ExampleInfoRequestDTO} should be validate without throws any exception.
     */
    @Test
    public void validateWithEmptyParameter1ShouldNotThrownAnyException() {
        exampleInfoRequestDTO.setParameter1("");
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with a blank parameter 1.
     * Expectation:
     * The {@link ExampleInfoRequestDTO} should be validate without throws any exception.
     */
    @Test
    public void validateWithBlankParameter1ShouldNotThrownAnyException() {
        exampleInfoRequestDTO.setParameter1(" ");
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with a null parameter 2.
     * Expectation:
     * A {@link NullPointerException} is thrown.
     */
    @Test
    public void validateWithNullParameter2ShouldThrowNullPointerException() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(ExampleMessage.EXAMPLE_INFO_PARAMETER_2_CAN_NOT_BE_EMPTY.getMessage());

        exampleInfoRequestDTO.setParameter2(null);
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with an empty parameter 2.
     * Expectation:
     * An {@link IllegalArgumentException} is thrown.
     */
    @Test
    public void validateWithEmptyParameter2ShouldThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ExampleMessage.EXAMPLE_INFO_PARAMETER_2_CAN_NOT_BE_EMPTY.getMessage());

        exampleInfoRequestDTO.setParameter2("");
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with a blank parameter 2.
     * Expectation:
     * An {@link IllegalArgumentException} is thrown.
     */
    @Test
    public void validateWithBlankParameter2ShouldThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ExampleMessage.EXAMPLE_INFO_PARAMETER_2_CAN_NOT_BE_EMPTY.getMessage());

        exampleInfoRequestDTO.setParameter2(" ");
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with a null parameter 3.
     * Expectation:
     * A {@link NullPointerException} is thrown.
     */
    @Test
    public void validateWithNullParameter3ShouldThrowNullPointerException() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(ExampleMessage.EXAMPLE_INFO_PARAMETER_3_CAN_NOT_BE_EMPTY.getMessage());

        exampleInfoRequestDTO.setParameter3(null);
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with an empty parameter 3.
     * Expectation:
     * An {@link IllegalArgumentException} is thrown.
     */
    @Test
    public void validateWithEmptyParameter3ShouldThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ExampleMessage.EXAMPLE_INFO_PARAMETER_3_CAN_NOT_BE_EMPTY.getMessage());

        exampleInfoRequestDTO.setParameter3("");
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with a blank parameter 3.
     * Expectation:
     * An {@link IllegalArgumentException} is thrown.
     */
    @Test
    public void validateWithBlankParameter3ShouldThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ExampleMessage.EXAMPLE_INFO_PARAMETER_3_CAN_NOT_BE_EMPTY.getMessage());

        exampleInfoRequestDTO.setParameter3(" ");
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with parameter 2 without numeric format.
     * Expectation:
     * An {@link IllegalArgumentException} is thrown.
     */
    @Test
    public void validateWithNonNumericParameter2ShouldThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ExampleMessage.EXAMPLE_INFO_PARAMETER_2_SHOULD_BE_NUMERIC.getMessage());

        exampleInfoRequestDTO.setParameter2("NaN"); // not a number value
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with a parameter 3 without valid date length.
     * Expectation:
     * An {@link IllegalArgumentException} is thrown.
     */
    @Test
    public void validateWithNonDateLengthParameter3ShouldThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ExampleMessage.EXAMPLE_INFO_PARAMETER_3_FORMAT_SHOULD_BE_YYYYMMDD.getMessage());

        exampleInfoRequestDTO.setParameter3("201001");
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoRequestDTOValidator#validate(ExampleInfoRequestDTO)}
     * with a parameter 3 without valid date format YYYYMMDD.
     * Expectation:
     * An {@link IllegalArgumentException} is thrown.
     */
    @Test
    public void validateWithParameter3WithOutValidDateFormantShouldThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ExampleMessage.EXAMPLE_INFO_PARAMETER_3_FORMAT_SHOULD_BE_YYYYMMDD.getMessage());

        exampleInfoRequestDTO.setParameter3("ABCD00$$");
        exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
    }
}
```