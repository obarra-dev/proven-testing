package com.obarra.littletaste.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses({
    BeforeAfterTest.class,
    ParameterizedTest.class
})
public class SuitTestTest {
}
