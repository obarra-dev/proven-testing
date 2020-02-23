package com.obarra.littletaste.java8.converter;

import com.obarra.littletaste.Person;
import com.obarra.littletaste.PersonDTO;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonConverterTest {

    private PersonConverter personConverter;

    @BeforeEach
    public void setUp(){
        personConverter = new PersonConverter();
    }

    @Test
    public void applyWithValidParameterShouldBeReturnPerson() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName("Omar");
        personDTO.setLastName("Barra");
        personDTO.setSecondLastName("Quelca");

        Person result = personConverter.apply(personDTO);

        Person expected = new Person();
        expected.setFirstName("Omar");
        expected.setLastName("Barra");
        expected.setSecondLastName("Quelca");

        assertNotNull(result);
        assertEquals(expected.getFirstName(), result.getFirstName());
        assertEquals(expected.getLastName(), result.getLastName());
        assertEquals(expected.getSecondLastName(), result.getSecondLastName());
    }

    @Test
    public void applyWithValidListOfParameterShouldBeReturnListOfPersons() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName("Omar");
        personDTO.setLastName("Barra");
        personDTO.setSecondLastName("Quelca");

        List<PersonDTO> personDTOs = new ArrayList<>();
        personDTOs.add(personDTO);

        personDTO = new PersonDTO();
        personDTO.setFirstName("Mara");
        personDTO.setLastName("Vila");
        personDTO.setSecondLastName("Cora");
        personDTOs.add(personDTO);

        List<Person> result = personConverter.apply(personDTOs);

        Person person = new Person();
        person.setFirstName("Omar");
        person.setLastName("Barra");
        person.setSecondLastName("Quelca");

        List<Person> expected = new ArrayList<>();
        expected.add(person);

        person = new Person();
        person.setFirstName("Mara");
        person.setLastName("Vila");
        person.setSecondLastName("Cora");
        expected.add(person);

        assertNotNull(result);
        MatcherAssert.assertThat(result, Matchers.hasSize(2));
        MatcherAssert.assertThat(result, Matchers.not(Matchers.empty()));
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder(result.toArray()));
        MatcherAssert.assertThat(result, Matchers.contains(result.toArray()));
    }
}