package com.obarra.proventesting.java8.converter;

import com.obarra.proventesting.Person;
import com.obarra.proventesting.PersonDTO;


public class PersonDTOConverter implements GenericConverter<PersonDTO, Person> {

    @Override
    public PersonDTO apply(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setSecondLastName(person.getSecondLastName());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        return personDTO;
    }
}
