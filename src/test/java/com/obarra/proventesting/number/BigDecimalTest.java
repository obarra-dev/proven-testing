package com.obarra.proventesting.number;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test to BigDecimal")
public class BigDecimalTest {

    /**
     * Scenario:
     * When rest two numbers with different scale.
     * Expectation:
     * Should be return a number with the largest scale.
     */
    @Test
    public void restWhenTheNumbersHaveDifferentScale() {
        BigDecimal number = new BigDecimal("1000.0");
        BigDecimal otherNumber = new BigDecimal("0.001");
        BigDecimal result = number.subtract(otherNumber);
        BigDecimal expectedResult = new BigDecimal("999.999");
        assertEquals(expectedResult, result);
    }

    @Test
    public void multiply() {
        BigDecimal number = new BigDecimal("10.00");
        BigDecimal tax = new BigDecimal("0.0825");
        BigDecimal result = number.multiply(tax);
        BigDecimal expectedResult = new BigDecimal("0.825000");
        assertEquals(expectedResult, result);
    }

    @Nested
    @DisplayName("Test add method")
    class AddTest {

        /**
         * Scenario:
         * When add two numbers with the same scale.
         * Expectation:
         * Should be return a number with the same scale.
         */
        @Test
        public void addWhenNumbersAreTheSameScale() {
            BigDecimal number = new BigDecimal("0.3");
            BigDecimal otherNumber = new BigDecimal("0.7");
            BigDecimal result = number.add(otherNumber);
            BigDecimal expectedResult = new BigDecimal("1.0");
            assertEquals(expectedResult, result);
        }

        /**
         * Scenario:
         * When add two numbers with different scale.
         * Expectation:
         * Should be return a number with the largest scale.
         */
        @Test
        public void addWhenNumbersAreNotTheSameScale() {
            BigDecimal number = new BigDecimal("0.30");
            BigDecimal otherNumber = new BigDecimal("0.7");
            BigDecimal result = number.add(otherNumber);
            BigDecimal expectedResult = new BigDecimal("1.0");
            assertNotEquals(expectedResult, result);
        }
    }

    @Nested
    @DisplayName("test divide method")
    class DivideTest {
        /**
         * Scenario:
         * When the scale is insufficient to represent the result (1/3 = 0.3333333.....) and the round mode is UNNECESSARY
         * Expectation:
         * Should be throw a ArithmeticException
         */
        @Test
        public void divideWhenScaleIsInsufficientToRepresentTheResult() {
            BigDecimal dividend = new BigDecimal("1");
            BigDecimal divisor = new BigDecimal("3");
            assertThrows(ArithmeticException.class, () -> dividend.divide(divisor));
        }

        /**
         * Scenario:
         * When divide numbers where the scale is sufficient to represent the result (1/3 = 0.3333333.....) and the round mode is different to UNNECESSARY
         * Expectation:
         * Should be return a number with a definite scale
         */
        @Test
        public void divideWhenExistScaleAndRoundMode() {
            BigDecimal dividend = new BigDecimal("1");
            BigDecimal divisor = new BigDecimal("3");
            BigDecimal result = dividend.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
            BigDecimal expectedResult = new BigDecimal("0.33");
            assertEquals(expectedResult, result);
        }

        /**
         * Scenario:
         * When divide numbers and the divisor is Zero
         * Expectation:
         * Should be throw a ArithmeticException
         */
        @Test
        public void divideWhenTheDivisorIsZero() {
            BigDecimal dividend = new BigDecimal("1");
            BigDecimal divisor = new BigDecimal("0");
            assertThrows(ArithmeticException.class, () -> dividend.divide(divisor, 2, BigDecimal.ROUND_HALF_UP));
        }
    }

    @Nested
    @DisplayName("Test constructor BigDecimal")
    class ConstructorClass {
        /**
         * Scenario:
         * When creating a BigDecimal from a Double value.
         * Expectation:
         * Should not hold the exact precision, this constructor can be somewhat unpredictable.
         */
        @Test
        public void bigDecimalWhenCreatesFromDoubleShouldNotHoldTheExactPrecision() {
            BigDecimal number = new BigDecimal(0.33);
            assertNotEquals("0.33", number.toString());
        }

        /**
         * Scenario:
         * When creating a BigDecimal from a String.
         * Expectation:
         * Should hold the exact precision, it is good idea.
         */
        @Test
        public void bigDecimalWhenCreatesFromStringShouldHoldTheExactPrecision() {
            BigDecimal number = new BigDecimal("0.33");
            assertEquals("0.33", number.toString());
        }
    }

    @Nested
    class RoundTest {

        /**
         * Scenario:
         * When uses rounding mode ROUND_CEILING in positive number
         * Expectation:
         * Should round towards positive infinity.
         */
        @Test
        public void roundCeilingWhenNumberIsPositive() {
            BigDecimal number = new BigDecimal("0.333");
            BigDecimal result = number.setScale(2, BigDecimal.ROUND_CEILING);
            BigDecimal expectedResult = new BigDecimal("0.34");
            assertEquals(expectedResult, result);
        }

        /**
         * Scenario:
         * When uses rounding mode ROUND_CEILING in negative number
         * Expectation:
         * Should round towards positive infinity.
         */
        @Test
        public void roundCeilingWhenNumberIsNegative() {
            BigDecimal number = new BigDecimal("-0.333");
            BigDecimal result = number.setScale(2, BigDecimal.ROUND_CEILING);
            BigDecimal expectedResult = new BigDecimal("-0.33");
            assertEquals(expectedResult, result);
        }

        /**
         * Scenario:
         * When uses rounding mode ROUND_FLOOR in positive number
         * Expectation:
         * Should round towards negative infinity.
         */
        @Test
        public void roundFloorWhenTheNumberIsPositive() {
            BigDecimal number = new BigDecimal("0.333");
            BigDecimal result = number.setScale(2, BigDecimal.ROUND_FLOOR);
            BigDecimal expectedResult = new BigDecimal("0.33");
            assertEquals(expectedResult, result);
        }

        /**
         * Scenario:
         * When uses rounding mode ROUND_FLOOR in negative number
         * Expectation:
         * Should round towards negative infinity.
         */
        @Test
        public void roundFloorWhenTheNumberIsNegative() {
            BigDecimal number = new BigDecimal("-0.333");
            BigDecimal result = number.setScale(2, BigDecimal.ROUND_FLOOR);
            BigDecimal expectedResult = new BigDecimal("-0.34");
            assertEquals(expectedResult, result);
        }

        /**
         * Scenario:
         * When uses rounding mode ROUND_DOWN in positive number
         * Expectation:
         * Should round towards zero.
         */
        @Test
        public void roundDownWhenTheNumberISPositive() {
            BigDecimal number = new BigDecimal("0.333");
            BigDecimal result = number.setScale(2, BigDecimal.ROUND_DOWN);
            BigDecimal expectedResult = new BigDecimal("0.33");
            assertEquals(expectedResult, result);
        }

        /**
         * Scenario:
         * When uses rounding mode ROUND_DOWN in negative number
         * Expectation:
         * Should round towards zero.
         */
        @Test
        public void roundDownWhenTheNumberIsNegative() {
            BigDecimal number = new BigDecimal("-0.333");
            BigDecimal result = number.setScale(2, BigDecimal.ROUND_DOWN);
            BigDecimal expectedResult = new BigDecimal("-0.33");
            assertEquals(expectedResult, result);
        }


        /**
         * Scenario:
         * When uses rounding mode ROUND_UP in positive number
         * Expectation:
         * Should round away from zero.
         */
        @Test
        public void roundUpWhenTheNumberIsPositive() {
            BigDecimal number = new BigDecimal("0.333");
            BigDecimal result = number.setScale(2, BigDecimal.ROUND_UP);
            BigDecimal expectedResult = new BigDecimal("0.34");
            assertEquals(expectedResult, result);
        }

        /**
         * Scenario:
         * When uses rounding mode ROUND_UP in negative number
         * Expectation:
         * Should round away from zero.
         */
        @Test
        public void roundDownTowardsZeroNegative() {
            BigDecimal number = new BigDecimal("-0.333");
            BigDecimal result = number.setScale(2, BigDecimal.ROUND_UP);
            BigDecimal expectedResult = new BigDecimal("-0.34");
            assertEquals(expectedResult, result);
        }

        @Nested
        @DisplayName("Test Round Half")
        class RoundHalfTest {
            /**
             * Scenario:
             * When uses rounding mode ROUND_HALF_UP and the last decimal is greater or equals than 5.
             * Expectation:
             * Should round away from zero
             */
            @Test
            public void roundHalfUpWhenTheLastDecimalIsFive() {
                BigDecimal number = new BigDecimal("0.745");
                BigDecimal result = number.setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal expectedResult = new BigDecimal("0.75");
                assertEquals(expectedResult, result);
            }

            /**
             * Scenario:
             * When uses rounding mode ROUND_HALF_UP and the last decimal is less than 5.
             * Expectation:
             * Should round towards nearest neighbor
             */
            @Test
            public void roundHalfUpWhenTheLastDecimalIsFour() {
                BigDecimal number = new BigDecimal("0.744");
                BigDecimal result = number.setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal expectedResult = new BigDecimal("0.74");
                assertEquals(expectedResult, result);
            }

            /**
             * Scenario:
             * When uses rounding mode ROUND_HALF_DOWN and the last decimal is less or equals than 5.
             * Expectation:
             * Should round towards zero
             */
            @Test
            public void roundHalfDownWhenTheLastDecimalIsFive() {
                BigDecimal number = new BigDecimal("0.745");
                BigDecimal result = number.setScale(2, BigDecimal.ROUND_HALF_DOWN);
                BigDecimal expectedResult = new BigDecimal("0.74");
                assertEquals(expectedResult, result);
            }

            /**
             * Scenario:
             * When uses rounding mode ROUND_HALF_DOWN and the last decimal is greater than 5.
             * Expectation:
             * Should round towards nearest neighbor
             */
            @Test
            public void roundHalfDownWhenTheLastDecimalIsFour() {
                BigDecimal number = new BigDecimal("0.746");
                BigDecimal result = number.setScale(2, BigDecimal.ROUND_HALF_DOWN);
                BigDecimal expectedResult = new BigDecimal("0.75");
                assertEquals(expectedResult, result);
            }

            /**
             * Scenario:
             * When uses rounding mode ROUND_HALF_EVEN and the digit of left is even.
             * Expectation:
             * Should round down
             */
            @Test
            public void roundHalfEvenWhenDigitLeftIsEven() {
                BigDecimal number = new BigDecimal("1.5");
                BigDecimal result = number.setScale(0, BigDecimal.ROUND_HALF_EVEN);
                BigDecimal expectedResult = new BigDecimal("2");
                assertEquals(expectedResult, result);
            }

            /**
             * Scenario:
             * When uses rounding mode ROUND_HALF_EVEN and the digit of left is odd.
             * Expectation:
             * Should round up
             */
            @Test
            public void roundHalfEvenWhenDigitLeftIsOdd() {
                BigDecimal number = new BigDecimal("2.5");
                BigDecimal result = number.setScale(0, BigDecimal.ROUND_HALF_EVEN);
                BigDecimal expectedResult = new BigDecimal("2");
                assertEquals(expectedResult, result);
            }

        }

        /**
         * Scenario:
         * When uses rounding mode ROUND_UNNECESSARY and the number has decimals.
         * Expectation:
         * Should throw ArithmeticException.
         */
        @Test
        public void roundUnnecessaryWhenTheNumberHasDecimals() {
            BigDecimal number = new BigDecimal("2.5");
            assertThrows(ArithmeticException.class, () -> number.setScale(0, BigDecimal.ROUND_UNNECESSARY));
        }
    }
}