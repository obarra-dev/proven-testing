package com.obarra.littletaste.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prime {

    public static boolean isPrime(final int number){
        if(number == 1)
            return false;

        if(number == 2)
            return true;

        if(isMultipleOfTwo(number))
            return false;

        return isPrimeCheckOdds(number);
    }

    private static boolean isMultipleOfTwo(final int number) {
        return number%2 == 0;
    }

    private static boolean isPrimeCheckOdds(final int number){
       for(int i = 3; i*i <= number; i+=2){
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public static List<Integer> generatePrimesBySieveOfEratosthenes(final Integer limit){
        boolean primesOrNot[] = new boolean[limit + 1];
        Arrays.fill(primesOrNot, true);

        for(int i = 2; i*i  <= limit; i++){
            if(primesOrNot[i]){
                for(int j = i*i; j <= limit; j+=i){
                    primesOrNot[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i < limit; i++){
            if(primesOrNot[i])
                primes.add(i);
        }
        return primes;
    }
}
