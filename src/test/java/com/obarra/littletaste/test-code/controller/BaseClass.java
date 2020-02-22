
package com.example.springboot.poc.controller;

import com.example.springboot.poc.dto.ExampleErrorResponseDTO;
import com.example.springboot.poc.dto.ExampleInfoRequestDTO;
import com.example.springboot.poc.message.ExampleMessage;
import com.example.springboot.poc.service.ExampleService;
import com.example.springboot.poc.validator.ExampleInfoRequestDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A description of {@link ExampleController} features.
 * Created by [YOUR ID] on 8/1/2018.
 */
@Component // you also can use @Controller or @RestController (it inherits from @Component)
@RequestMapping("/example/get/") // best practice: use descriptive path names
public class ExampleController { // best practice: use Controller suffix when create a controller component

    private ExampleService exampleService; // best practice: use private scope + descriptive names for attributes
    private ExampleInfoRequestDTOValidator exampleInfoRequestDTOValidator;

    /**
     * Constructor for {@link ExampleController}.
     * @param exampleService the {@link ExampleService} for {@link ExampleController}
     * @param exampleInfoRequestDTOValidator the {@link ExampleInfoRequestDTOValidator} for {@link ExampleController}
     */
    @Autowired // best practice: use injection by constructor makes unit test easier
    public ExampleController(final ExampleService exampleService, //  best practice: use final modifier for parameters
                             final ExampleInfoRequestDTOValidator exampleInfoRequestDTOValidator) {
        this.exampleService = exampleService;
        this.exampleInfoRequestDTOValidator = exampleInfoRequestDTOValidator;
    }

    /**
     * A description of method behavior or actions.
     * @param exampleInfoRequestDTO example info request parameters
     * @return a {@link ResponseEntity} with http status and execution result
     */
    // best practice: you also can use @RequestMapping with same modifiers
    @PostMapping(value = "/info", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // best practice: use descriptive names for methods + use final modifier for parameters
    public ResponseEntity<Object> getExampleInfo(@RequestBody final ExampleInfoRequestDTO exampleInfoRequestDTO) {
        try {
            // best practice: validate method parameters (in this case mapped from http request)
            exampleInfoRequestDTOValidator.validate(exampleInfoRequestDTO);
            // happy path flow should return an ok response (HTTP Status 200)
            return ResponseEntity.ok(exampleService.getExampleInfo(exampleInfoRequestDTO));
        } catch (Exception e) { // best practice: don't use Exception in catch statements, use expected exception classes
            // unhappy path flow should return some info about
            ExampleErrorResponseDTO exampleErrorResponseDTO = new ExampleErrorResponseDTO();
            exampleErrorResponseDTO.setStatus(ExampleMessage.EXAMPLE_STATUS_ERROR.getMessage());
            exampleErrorResponseDTO.setMessage(e.getMessage());
            // unhappy path flow should return error info + internal server error (HTTP Status 500)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exampleErrorResponseDTO);
        }
    }
}