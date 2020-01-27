package com.obarra.littletaste.java8;

import com.obarra.littletaste.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.LongBinaryOperator;
import java.util.function.Predicate;

public class PredicateTest {

    @Test
    public void test(){
        Predicate<Person> doNotHaveSecondLastName = (person) -> person.getSecondLastName() == null;
        Person person = new Person();
        Assert.assertTrue(doNotHaveSecondLastName.test(person));
    }
}
