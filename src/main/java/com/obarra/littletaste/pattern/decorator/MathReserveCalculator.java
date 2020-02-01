package com.obarra.littletaste.pattern.decorator;

import com.obarra.littletaste.pattern.decorator.legacy.InsuranceCalculator;

public class MathReserveCalculator extends  CalculatorDecorator{

    public MathReserveCalculator(InsuranceCalculator insuranceCalculator) {
        super(insuranceCalculator);
    }

    @Override
    public double calculate(double value) {
        return super.getInsuranceCalculator().calculate(value)*100;
    }
}
