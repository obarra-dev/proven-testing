package com.obarra.littletaste.java8;

import com.obarra.littletaste.Person;
import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.LongBinaryOperator;
import java.util.function.Predicate;

public class BiPredicateTest {

    @Test
    public void test(){
        BiPredicate<Person, Person> areRelatives = (person, otherPerson) ->
            person.getLastName().equals(otherPerson.getLastName());
        Person person = new Person();
        person.setLastName("Barreto");

        Person otherPerson = new Person();
        otherPerson.setLastName("Barra");
        assertFalse(areRelatives.test(person, otherPerson));
    }
}
