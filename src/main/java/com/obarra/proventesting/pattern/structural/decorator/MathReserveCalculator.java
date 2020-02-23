package com.obarra.proventesting.pattern.structural.decorator;

import com.obarra.proventesting.pattern.structural.decorator.legacy.InsuranceCalculator;

public class MathReserveCalculator extends  CalculatorDecorator{

    public MathReserveCalculator(InsuranceCalculator insuranceCalculator) {
        super(insuranceCalculator);
    }

    @Override
    public double calculate(double value) {
        return super.getInsuranceCalculator().calculate(value)*100;
    }
}
