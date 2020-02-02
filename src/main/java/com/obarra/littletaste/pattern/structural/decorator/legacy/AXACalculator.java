package com.obarra.littletaste.pattern.structural.decorator.legacy;

public class AXACalculator implements InsuranceCalculator{
    @Override
    public double calculate(double value) {
        return value*5.5;
    }
}
