```java
package com.example.springboot.poc.validator;

import com.example.springboot.poc.dto.ExampleInfoRequestDTO;
import com.example.springboot.poc.message.ExampleMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

/**
 * Validator for {@link ExampleInfoRequestDTO}.
 * Created by [YOUR ID] on 8/1/2018.
 */
@Component
public class ExampleInfoRequestDTOValidator {
    private static final int DATE_PARAMETER_LENGTH = 8; // best practice: use constant values to avoid magic numbers or strings
    private static final String DATE_PARAMETER_FORMAT = "yyyyMMdd"; // best practice: use constant values to avoid magic numbers or strings

    /**
     * Validates the given {@link ExampleInfoRequestDTO}.
     * @param exampleInfoRequestDTO to be validated.
     */
    public void validate(final ExampleInfoRequestDTO exampleInfoRequestDTO) {
        Validate.notNull(exampleInfoRequestDTO,
                ExampleMessage.EXAMPLE_INFO_REQUEST_CAN_NOT_BE_NULL.getMessage());
        Validate.notNull(exampleInfoRequestDTO.getParameter1(),
                ExampleMessage.EXAMPLE_INFO_PARAMETER_1_CAN_NOT_BE_NULL.getMessage());
        Validate.notBlank(exampleInfoRequestDTO.getParameter2(),
                ExampleMessage.EXAMPLE_INFO_PARAMETER_2_CAN_NOT_BE_EMPTY.getMessage());
        Validate.isTrue(StringUtils.isNumeric(exampleInfoRequestDTO.getParameter2()),
                ExampleMessage.EXAMPLE_INFO_PARAMETER_2_SHOULD_BE_NUMERIC.getMessage());
        Validate.notBlank(exampleInfoRequestDTO.getParameter3(),
                ExampleMessage.EXAMPLE_INFO_PARAMETER_3_CAN_NOT_BE_EMPTY.getMessage());
        Validate.isTrue(exampleInfoRequestDTO.getParameter3().length() == DATE_PARAMETER_LENGTH,
                ExampleMessage.EXAMPLE_INFO_PARAMETER_3_FORMAT_SHOULD_BE_YYYYMMDD.getMessage());

        try {
            DateUtils.parseDate(exampleInfoRequestDTO.getParameter3(), DATE_PARAMETER_FORMAT);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExampleMessage.EXAMPLE_INFO_PARAMETER_3_FORMAT_SHOULD_BE_YYYYMMDD.getMessage());
        }
    }
}
```