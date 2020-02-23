package com.obarra.proventesting.java8;

import com.obarra.proventesting.Person;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {

    @Test
    public void apply(){
        Function<Person, Person> mix = (person) -> {
            Person newPerson = new Person();
            newPerson.setLastName(person.getSecondLastName());
            newPerson.setFirstName(person.getLastName());
            newPerson.setSecondLastName(person.getFirstName());
            return  newPerson;
        };

        Person person = new Person();
        person.setLastName("Barra");
        person.setFirstName("Omar");
        person.setSecondLastName("Barreto");

        Person otherPerson = mix.apply(person);

        assertEquals(person.getFirstName(), otherPerson.getSecondLastName());
        assertEquals(person.getLastName(), otherPerson.getFirstName());
        assertEquals(person.getSecondLastName(), otherPerson.getLastName());
    }
}