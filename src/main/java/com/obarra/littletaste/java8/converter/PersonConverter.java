package com.obarra.littletaste.java8.converter;

import com.obarra.littletaste.Person;
import com.obarra.littletaste.PersonDTO;


public class PersonConverter implements GenericConverter<Person, PersonDTO> {

    @Override
    public Person apply(final PersonDTO personDTO) {
        Person person = new Person();
        person.setSecondLastName(personDTO.getSecondLastName());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        return person;
    }

}
