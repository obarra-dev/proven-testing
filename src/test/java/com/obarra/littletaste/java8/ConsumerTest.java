package com.obarra.littletaste.java8;

import com.obarra.littletaste.Person;
import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerTest {

    @Test
    public void accept(){
        Consumer<Person> mix = (person) -> {
            String auxiliary = person.getLastName();
            person.setLastName(person.getSecondLastName());
            person.setSecondLastName(person.getFirstName());
            person.setFirstName(auxiliary);

        };

        Person person = new Person();
        person.setLastName("Barra");
        person.setFirstName("Omar");
        person.setSecondLastName("Barreto");

        mix.accept(person);

        assertEquals("Omar", person.getSecondLastName());
        assertEquals("Barra", person.getFirstName());
        assertEquals("Barreto", person.getLastName());
    }
}