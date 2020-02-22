
package com.example.springboot.poc.converter;

import com.example.springboot.poc.dto.ExampleInfoResponseDTO;
import com.example.springboot.poc.entity.ExampleEntity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Unit test cases for {@link ExampleInfoConverterImpl}
 */
// best practice: for performance reasons, we don't have to use any test runner
public class ExampleInfoConverterImplTest {
    @Rule //best practice: annotated objects at the begin of the class
    public ExpectedException thrown = ExpectedException.none();

    // best practice: declare common objects as class attributes (avoid duplicated code)
    private ExampleInfoConverterImpl exampleInfoConverter;


    // best practice: initialize objects or mocks before each test execution
    @Before
    public void setup() {
        exampleInfoConverter = new ExampleInfoConverterImpl();
    }

    // best practice: each unit test should include a scenario description: execution conditions and expected results
    // best practice: each unit test should have a descriptive name: method's name + conditions + should + expected result
    // advantages:
    // 1. creates unit test with similar format.
    // 2. helps to understand test logic.
    // 3. shows quickly what it should do and return without execute it.
    /**
     * Scenario:
     * Execute {@link ExampleInfoConverterImpl#apply(ExampleEntity)}
     * with valid parameters.
     * Expectation:
     * An {@link ExampleInfoResponseDTO} with valid values is returned.
     */
    @Test
    public void applyWithValidParametersShouldReturnExampleInfoResponseDTO() {
        // best practice: use expected word for expected values of mocks
        // we define here because we expect different values in each test case
        ExampleInfoResponseDTO expectedExampleInfoResponseDTO = new ExampleInfoResponseDTO();
        expectedExampleInfoResponseDTO.setName("someName");
        expectedExampleInfoResponseDTO.setDescription("someDescription");

        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setColumn1("someId");
        exampleEntity.setColumn2("someName");
        exampleEntity.setColumn3("someDescription");

        ExampleInfoResponseDTO result = exampleInfoConverter.apply(exampleEntity);

        // best practice: first of all: assert for the result to check if it's null
        assertThat(result, notNullValue());
        // assert if name attribute has the proper value
        assertThat(result.getName(), equalTo(exampleEntity.getColumn2()));
        // assert if description attribute has the proper value
        assertThat(result.getDescription(), equalTo(exampleEntity.getColumn3()));
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoConverterImpl#apply(ExampleEntity)}
     * with null entity.
     * Expectation:
     * A {@link NullPointerException} is thrown.
     */
    @Test
    public void applyWithNullEntityShouldThrowNullPointerException() {
        thrown.expect(NullPointerException.class);
        exampleInfoConverter.apply(null);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoConverterImpl#apply(ExampleEntity)}
     * with empty entity.
     * Expectation:
     * An {@link ExampleInfoResponseDTO} with null values is returned.
     */
    @Test
    public void applyWithEmptyEntityShouldReturnExampleInfoResponseDTO() {
        ExampleInfoResponseDTO result = exampleInfoConverter.apply(new ExampleEntity());

        // best practice: first of all: assert for the result to check if it's null
        assertThat(result, notNullValue());
        // assert if name attribute has the proper value
        assertThat(result.getName(), nullValue());
        // assert if description attribute has the proper value
        assertThat(result.getDescription(), nullValue());
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoConverterImpl#convertToList(List)}
     * with valid parameters.
     * Expectation:
     * A {@link List} of {@link ExampleInfoResponseDTO} with valid values is returned.
     */
    @Test
    public void convertToListWithValidParametersShouldReturnExampleInfoResponseDTOList() {
        // best practice: use expected word for expected values of mocks
        // we define here because we expect different values in each test case
        ExampleEntity exampleEntity1 = new ExampleEntity();
        exampleEntity1.setColumn1("someId1");
        exampleEntity1.setColumn2("someName1");
        exampleEntity1.setColumn3("someDescription1");

        ExampleEntity exampleEntity2 = new ExampleEntity();
        exampleEntity2.setColumn1("someId2");
        exampleEntity2.setColumn2("someName2");
        exampleEntity2.setColumn3("someDescription2");

        List<ExampleEntity> exampleEntityList = Arrays.asList(exampleEntity1, exampleEntity2);

        List<ExampleInfoResponseDTO> result = exampleInfoConverter.convertToList(exampleEntityList);

        // best practice: first of all: assert for the result to check if it's null
        assertThat(result, notNullValue());
        assertThat(result.size(), equalTo(exampleEntityList.size()));
        // assert if name attribute has the proper value for element 0
        assertThat(result.get(0).getName(), equalTo(exampleEntity1.getColumn2()));
        // assert if name attribute has the proper value for element 1
        assertThat(result.get(1).getName(), equalTo(exampleEntity2.getColumn2()));
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoConverterImpl#convertToList(List)}
     * with empty entity list.
     * Expectation:
     * A {@link List} of {@link ExampleInfoResponseDTO} without values is returned.
     */
    @Test
    public void convertToListWithEmptyParametersShouldReturnEmptyExampleInfoResponseDTOList() {
        // best practice: use expected word for expected values of mocks
        // we define here because we expect different values in each test case
        List<ExampleInfoResponseDTO> result = exampleInfoConverter.convertToList(Collections.EMPTY_LIST);

        // best practice: first of all: assert for the result to check if it's null
        assertThat(result, notNullValue());
        assertThat(result.size(), equalTo(0));
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoConverterImpl#convertToList(List)}
     * with null entity list.
     * Expectation:
     * A {@link NullPointerException} is thrown.
     */
    @Test
    public void convertToListWithNullParametersShouldThrowNullPointerException() {
        thrown.expect(NullPointerException.class);
        exampleInfoConverter.convertToList(null);
    }

    /**
     * Scenario:
     * Execute {@link ExampleInfoConverterImpl#convertToList(List)}
     * with valid entity list and null elements.
     * Expectation:
     * A {@link NullPointerException} is thrown.
     */
    @Test
    public void convertToListWithListOfNullElementsShouldThrowNullPointerException() {
        thrown.expect(NullPointerException.class);
        exampleInfoConverter.convertToList(Arrays.asList(null));
    }
}