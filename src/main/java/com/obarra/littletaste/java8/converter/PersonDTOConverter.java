package com.obarra.littletaste.java8.converter;

import com.obarra.littletaste.Person;
import com.obarra.littletaste.PersonDTO;


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
