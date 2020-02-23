package com.obarra.proventesting.java8.converter;

import com.obarra.proventesting.Person;
import com.obarra.proventesting.PersonDTO;


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
