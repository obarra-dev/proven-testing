package com.obarra.littletaste.java8;

import com.obarra.littletaste.Person;
import com.obarra.littletaste.java8.funtionalinterface.ArrayInitializer;
import com.obarra.littletaste.java8.funtionalinterface.Constant;
import com.obarra.littletaste.java8.funtionalinterface.Operator;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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

        Assert.assertEquals(person.getFirstName(), otherPerson.getSecondLastName());
        Assert.assertEquals(person.getLastName(), otherPerson.getFirstName());
        Assert.assertEquals(person.getSecondLastName(), otherPerson.getLastName());
    }
}