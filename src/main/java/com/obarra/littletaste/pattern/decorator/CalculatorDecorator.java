package com.obarra.littletaste.pattern.decorator;

import com.obarra.littletaste.pattern.decorator.legacy.InsuranceCalculator;

public abstract class CalculatorDecorator implements InsuranceCalculator {

    private InsuranceCalculator insuranceCalculator;

    public CalculatorDecorator(InsuranceCalculator insuranceCalculator) {
        this.insuranceCalculator = insuranceCalculator;
    }

    public abstract double calculate(double value);

    public InsuranceCalculator getInsuranceCalculator() {
        return insuranceCalculator;
    }

    public void setInsuranceCalculator(InsuranceCalculator insuranceCalculator) {
        this.insuranceCalculator = insuranceCalculator;
    }
}
