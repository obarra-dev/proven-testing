package com.example.springboot.poc.message;

/**
 * Example message enumeration with error, warning and response messages
 * Created by [YOUR ID] on 8/10/2018.
 */
public enum ExampleMessage {
    EXAMPLE_STATUS_OK("OK"),
    EXAMPLE_STATUS_ERROR("ERROR"),
    EXAMPLE_INFO_REQUEST_CAN_NOT_BE_NULL("The request cannot be null"),
    EXAMPLE_INFO_PARAMETER_1_CAN_NOT_BE_NULL("The parameter 1 cannot be null"),
    EXAMPLE_INFO_PARAMETER_2_CAN_NOT_BE_EMPTY("The parameter 2 cannot be null or empty"),
    EXAMPLE_INFO_PARAMETER_2_SHOULD_BE_NUMERIC("The parameter 2 should be a number"),
    EXAMPLE_INFO_PARAMETER_3_CAN_NOT_BE_EMPTY("The parameter 3 cannot be null or empty"),
    EXAMPLE_INFO_PARAMETER_3_FORMAT_SHOULD_BE_YYYYMMDD("The parameter 3 should be in YYYYMMDD format");

    private final String message;

    /**
     * Constructor for {@link ExampleMessage}
     * @param message the message
     */
    ExampleMessage(final String message) {
        this.message = message;
    }

    /**
     * Gets the constant message.
     * @return the message.
     */
    public String getMessage() {
        return message;
    }
}
