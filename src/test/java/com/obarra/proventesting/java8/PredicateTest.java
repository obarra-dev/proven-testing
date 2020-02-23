package com.obarra.proventesting.java8;

import com.obarra.proventesting.Person;
import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

public class PredicateTest {

    @Test
    public void test(){
        Predicate<Person> doNotHaveSecondLastName = (person) -> person.getSecondLastName() == null;
        Person person = new Person();
        assertTrue(doNotHaveSecondLastName.test(person));
    }
}
