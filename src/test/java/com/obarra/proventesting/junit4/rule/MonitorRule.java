package com.obarra.proventesting.junit4.rule;

import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class MonitorRule extends TestWatcher {
    /**
     * Invoked when a test succeeds
     */
    protected void succeeded(Description description) {
        System.out.printf("MonitorRule: %s succeeded%n", description.getMethodName());
    }

    /**
     * Invoked when a test fails
     */
    protected void failed(Throwable e, Description description) {
        System.out.printf("MonitorRule: %s failed with %s%n", description.getMethodName(), e);
    }

    /**
     * Invoked when a test is skipped due to a failed assumption.
     */
    @SuppressWarnings("deprecation")
    protected void skipped(AssumptionViolatedException e, Description description) {
        // For backwards compatibility with JUnit 4.11 and earlier, call the legacy version
        org.junit.internal.AssumptionViolatedException asInternalException = e;
        System.out.printf("MonitorRule: %s skipped%n", description.getMethodName());
    }

    /**
     * Invoked when a test is about to start
     */
    protected void starting(Description description) {
        System.out.printf("MonitorRule: %s is starting%n", description.getMethodName());
    }

    /**
     * Invoked when a test method finishes (whether passing or failing)
     */
    protected void finished(Description description) {
        System.out.printf("MonitorRule: %s finished%n", description.getMethodName());
    }

}
