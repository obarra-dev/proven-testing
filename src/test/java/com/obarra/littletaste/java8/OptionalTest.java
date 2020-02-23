package com.obarra.littletaste.java8;

import com.obarra.littletaste.Person;
import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    /**
     * Es mas explicito pero sigue siendo poco idiomatico, no es la forma mas habitual para trabajar con optional
     */
    @Test
    public void isPresentAndGet(){
        Person person = new Person();
        person.setFirstName("Omar");
        Optional<Person> optional = Optional.of(person);

        String greet;
        if(optional.isPresent()){
            greet = "Hi " + optional.get().getFirstName();
        }else{
            greet = "I'm alone";
        }

        assertEquals("Hi Omar", greet);
    }

    @Test
    public void mapAndOrElse(){
        Person person = new Person();
        person.setFirstName("Omar");
        Optional<Person> optional = Optional.of(person);

        String greet = optional.map(it -> "Hi " + it.getFirstName())
                .orElse("I'm Alone");
        assertEquals("Hi Omar", greet);
    }

    /**
     * Map solo se ejecuta si tiene elementos caso contratio devuelce otro Optional vacio
     */
    @Test
    public void mapAndOrElseWithReferenceMethods(){
        Person person = new Person();
        person.setFirstName("Omar");
        Optional<Person> optional = Optional.of(person);

        String greet = optional.map(Person::getFirstName)
                .map("Hi "::concat)
                .orElse("I'm Alone");
        assertEquals("Hi Omar", greet);
    }

    /**
     * Map solo se ejecuta si tiene elementos caso contratio devuelce otro Optional vacio
     */
    @Test
    public void flatMapAndOrElseWithReferenceMethods(){
        Person person = new Person();
        person.setFirstNameCanBeNull(Optional.ofNullable("Omar"));
        Optional<Person> optional = Optional.of(person);

        String greet = optional.flatMap(Person::getFirstNameCanBeNull)
                .map("Hi "::concat)
                .orElse("I'm Alone");
        assertEquals("Hi Omar", greet);
    }
}
