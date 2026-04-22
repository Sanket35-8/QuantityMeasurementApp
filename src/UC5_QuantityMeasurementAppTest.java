import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC5_QuantityMeasurementAppTest {

    private static final double EPSILON = 0.00001; // Tolerance for floating point precision

    @Test
    public void testConversion_FeetToInches() {
        double result = UC5_QuantityMeasurementApp.convert(1.0, UC5_QuantityMeasurementApp.LengthUnit.FEET, UC5_QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(12.0, result, EPSILON, "1.0 FEET should be 12.0 INCHES");
    }

    @Test
    public void testConversion_InchesToFeet() {
        double result = UC5_QuantityMeasurementApp.convert(24.0, UC5_QuantityMeasurementApp.LengthUnit.INCH, UC5_QuantityMeasurementApp.LengthUnit.FEET);
        assertEquals(2.0, result, EPSILON, "24.0 INCHES should be 2.0 FEET");
    }

    @Test
    public void testConversion_YardsToInches() {
        double result = UC5_QuantityMeasurementApp.convert(1.0, UC5_QuantityMeasurementApp.LengthUnit.YARDS, UC5_QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(36.0, result, EPSILON, "1.0 YARDS should be 36.0 INCHES");
    }

    @Test
    public void testConversion_InchesToYards() {
        double result = UC5_QuantityMeasurementApp.convert(72.0, UC5_QuantityMeasurementApp.LengthUnit.INCH, UC5_QuantityMeasurementApp.LengthUnit.YARDS);
        assertEquals(2.0, result, EPSILON, "72.0 INCHES should be 2.0 YARDS");
    }

    @Test
    public void testConversion_CentimetersToInches() {
        double result = UC5_QuantityMeasurementApp.convert(2.54, UC5_QuantityMeasurementApp.LengthUnit.CENTIMETERS, UC5_QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(1.0, result, EPSILON, "2.54 CM should be approximately 1.0 INCH");
    }

    @Test
    public void testConversion_FeetToYards() {
        double result = UC5_QuantityMeasurementApp.convert(6.0, UC5_QuantityMeasurementApp.LengthUnit.FEET, UC5_QuantityMeasurementApp.LengthUnit.YARDS);
        assertEquals(2.0, result, EPSILON, "6.0 FEET should be 2.0 YARDS");
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double originalValue = 5.0;
        double feetToCm = UC5_QuantityMeasurementApp.convert(originalValue, UC5_QuantityMeasurementApp.LengthUnit.FEET, UC5_QuantityMeasurementApp.LengthUnit.CENTIMETERS);
        double roundTripBackToFeet = UC5_QuantityMeasurementApp.convert(feetToCm, UC5_QuantityMeasurementApp.LengthUnit.CENTIMETERS, UC5_QuantityMeasurementApp.LengthUnit.FEET);
        assertEquals(originalValue, roundTripBackToFeet, EPSILON, "Round trip conversion should preserve original value");
    }

    @Test
    public void testConversion_ZeroValue() {
        double result = UC5_QuantityMeasurementApp.convert(0.0, UC5_QuantityMeasurementApp.LengthUnit.FEET, UC5_QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(0.0, result, EPSILON, "0.0 FEET should be 0.0 INCHES");
    }

    @Test
    public void testConversion_NegativeValue() {
        double result = UC5_QuantityMeasurementApp.convert(-1.0, UC5_QuantityMeasurementApp.LengthUnit.FEET, UC5_QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(-12.0, result, EPSILON, "-1.0 FEET should be -12.0 INCHES");
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            UC5_QuantityMeasurementApp.convert(1.0, null, UC5_QuantityMeasurementApp.LengthUnit.FEET);
        }, "Passing null source unit should throw IllegalArgumentException");

        assertThrows(IllegalArgumentException.class, () -> {
            UC5_QuantityMeasurementApp.convert(1.0, UC5_QuantityMeasurementApp.LengthUnit.FEET, null);
        }, "Passing null target unit should throw IllegalArgumentException");
    }

    @Test
    public void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            UC5_QuantityMeasurementApp.convert(Double.NaN, UC5_QuantityMeasurementApp.LengthUnit.FEET, UC5_QuantityMeasurementApp.LengthUnit.INCH);
        }, "Passing NaN should throw IllegalArgumentException");

        assertThrows(IllegalArgumentException.class, () -> {
            UC5_QuantityMeasurementApp.convert(Double.POSITIVE_INFINITY, UC5_QuantityMeasurementApp.LengthUnit.FEET, UC5_QuantityMeasurementApp.LengthUnit.INCH);
        }, "Passing Infinity should throw IllegalArgumentException");
    }
}