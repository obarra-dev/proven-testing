package com.obarra.proventesting.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTestTest {

    @RepeatedTest(4)
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getTotalRepetitions() / repetitionInfo.getCurrentRepetition());
        Assertions.assertTrue(true);
    }
}
