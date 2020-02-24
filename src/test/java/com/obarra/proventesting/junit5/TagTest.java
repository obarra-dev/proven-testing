package com.obarra.proventesting.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class TagTest {

    @Test
    @Tag("IT")
    void integrationTest(){
    }
}
