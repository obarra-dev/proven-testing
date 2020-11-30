package com.obarra.proventesting.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

public class TestInfoAndTestReporterTest {

    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        this.testReporter.publishEntry("Running " + this.testInfo.getDisplayName() + " with tag " + this.testInfo.getTags());
    }

    @Test
    void test() {

    }
}
