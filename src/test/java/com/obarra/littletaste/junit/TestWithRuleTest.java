package com.obarra.littletaste.junit;

import com.obarra.littletaste.junit.rule.MonitorRule;
import com.obarra.littletaste.junit.rule.RetryRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class TestWithRuleTest {

    @Rule
    public RetryRule retryRule = new RetryRule(2);

    @Rule
    public MonitorRule monitorRule = new MonitorRule();

    @Test
    public void dummyTest(){
        Assert.assertNotNull(new Object());
    }
}
