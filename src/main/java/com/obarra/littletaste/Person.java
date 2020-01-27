package com.obarra.littletaste;

import java.util.Optional;

public class Person {
    public String firstName;
    public String lastName;
    public String secondLastName;
    public Optional<String> firstNameCanBeNull;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getFirstNameCanBeNull() {
        return firstNameCanBeNull;
    }

    public void setFirstNameCanBeNull(Optional<String> firstNameCanBeNull) {
        this.firstNameCanBeNull = firstNameCanBeNull;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }
}
