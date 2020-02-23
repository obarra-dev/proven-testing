package com.obarra.proventesting.junit4.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryRule implements TestRule {

    private int quantityIntent;

    public RetryRule(int quantityIntent) {
        this.quantityIntent = quantityIntent;
    }

    @Override
    public Statement apply(Statement base, Description description) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable throwable = null;
                for (int i = 0; i < quantityIntent; i++) {
                    try{
                        base.evaluate();
                        System.out.println("It pass on intent: " + (i+1)  +" of total: "+quantityIntent);
                        return;
                    }catch (Throwable t){
                        throwable = t;
                    }
                }
                System.out.println("Giving up after the limit of failure");
                throw throwable;
            }
        };
    }

}
