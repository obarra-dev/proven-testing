package com.obarra.littletaste.pattern.decorator.legacy;

public class VillanuevaCalculator implements InsuranceCalculator{
    @Override
    public double calculate(double value) {
        return value*9.5;
    }
}
