package com.obarra.littletaste.pattern.decorator.legacy;

public class AXACalculator implements InsuranceCalculator{
    @Override
    public double calculate(double value) {
        return value*5.5;
    }
}
