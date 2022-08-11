package test.calculationMethods;

import static main.calculationMethods.CalculationMethods.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Calculation Methods test")
public class CalculationMethodsTest {
    double epsilon = 0.000001d;

    @Nested
    @DisplayName("Add method test")
    class AddTest {
        @DisplayName("Method should add numbers")
        @ParameterizedTest(name = "Adding {0} to {1} should equal {2}")
        @CsvFileSource(resources = "helperFiles/addTestParameters.csv", delimiter = ',', numLinesToSkip = 1)
        public void shouldAdd(double a, double b, double result) {
            assertEquals(result, add(a, b), epsilon);
        }
    }

    @Nested
    @DisplayName("Subtract method test")
    class SubtractTest {
        @DisplayName("Method should subtract numbers")
        @ParameterizedTest(name = "Subtracting {0} from {1} should equal {2}")
        @CsvFileSource(resources = "helperFiles/subtractTestParameters.csv", delimiter = ',', numLinesToSkip = 1)
        public void shouldSubtract(double a, double b, double result) {
            assertEquals(result, subtract(a, b), epsilon);
        }
    }

    @Nested
    @DisplayName("Multiply method test")
    class MultiplyTest {
        @DisplayName("Method should multiply numbers")
        @ParameterizedTest(name = "Multiplying {0} by {1} should equal {2}")
        @CsvFileSource(resources = "helperFiles/multiplyTestParameters.csv", delimiter = ',', numLinesToSkip = 1)
        public void shouldMultiply(double a, double b, double result) {
            assertEquals(result, multiply(a, b), epsilon);
        }
    }

    @Nested
    @DisplayName("Divide method test")
    class DivideTest {
        @DisplayName("Method should divide numbers")
        @ParameterizedTest(name = "Dividing {0} by {1} should equal {2}")
        @CsvFileSource(resources = "helperFiles/divideTestParameters.csv", delimiter = ',', numLinesToSkip = 1)
        public void shouldDivide(double a, double b, double result) {
            assertEquals(result, divide(a, b), epsilon);
        }

        @DisplayName("Method should do not divide by 0")
        @ParameterizedTest(name = "Dividing {0} by 0")
        @ValueSource(doubles = {0.7, 12.32, -122.423, 1200})
        public void shouldNotDivideBy0(double a) {
            double result = divide(a, 0);
            assertTrue(Double.isInfinite(result), "Divide by zero gives infinity as result");
        }
    }
}
