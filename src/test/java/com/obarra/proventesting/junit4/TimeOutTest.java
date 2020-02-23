package com.obarra.proventesting.junit4;

import org.junit.Test;

import java.util.Objects;

public class TimeOutTest {

    @Test(timeout = 100)
    public void timeOut(){
        Objects.hash("If this process will take more than 100 milliseconds it do not pass the test");
    }
}
