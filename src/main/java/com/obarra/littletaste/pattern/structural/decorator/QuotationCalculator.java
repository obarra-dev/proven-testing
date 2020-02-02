package com.obarra.littletaste.pattern.structural.decorator;

import com.obarra.littletaste.pattern.structural.decorator.legacy.InsuranceCalculator;

public class QuotationCalculator extends  CalculatorDecorator{

    public QuotationCalculator(InsuranceCalculator insuranceCalculator) {
        super(insuranceCalculator);
    }

    @Override
    public double calculate(double value) {
        return super.getInsuranceCalculator().calculate(value)*10;
    }
}
