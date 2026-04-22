import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC3_QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        UC3_QuantityMeasurementApp.Quantity feet1 = new UC3_QuantityMeasurementApp.Quantity(1.0, UC3_QuantityMeasurementApp.LengthUnit.FEET);
        UC3_QuantityMeasurementApp.Quantity feet2 = new UC3_QuantityMeasurementApp.Quantity(1.0, UC3_QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(feet1.equals(feet2), "1.0 feet should equal 1.0 feet");
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        UC3_QuantityMeasurementApp.Quantity inch1 = new UC3_QuantityMeasurementApp.Quantity(1.0, UC3_QuantityMeasurementApp.LengthUnit.INCH);
        UC3_QuantityMeasurementApp.Quantity inch2 = new UC3_QuantityMeasurementApp.Quantity(1.0, UC3_QuantityMeasurementApp.LengthUnit.INCH);
        assertTrue(inch1.equals(inch2), "1.0 inch should equal 1.0 inch");
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        UC3_QuantityMeasurementApp.Quantity oneFoot = new UC3_QuantityMeasurementApp.Quantity(1.0, UC3_QuantityMeasurementApp.LengthUnit.FEET);
        UC3_QuantityMeasurementApp.Quantity twelveInches = new UC3_QuantityMeasurementApp.Quantity(12.0, UC3_QuantityMeasurementApp.LengthUnit.INCH);
        assertTrue(oneFoot.equals(twelveInches), "1.0 feet should equal 12.0 inches");
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        UC3_QuantityMeasurementApp.Quantity twelveInches = new UC3_QuantityMeasurementApp.Quantity(12.0, UC3_QuantityMeasurementApp.LengthUnit.INCH);
        UC3_QuantityMeasurementApp.Quantity oneFoot = new UC3_QuantityMeasurementApp.Quantity(1.0, UC3_QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(twelveInches.equals(oneFoot), "12.0 inches should equal 1.0 feet (Symmetry)");
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        UC3_QuantityMeasurementApp.Quantity feet1 = new UC3_QuantityMeasurementApp.Quantity(1.0, UC3_QuantityMeasurementApp.LengthUnit.FEET);
        UC3_QuantityMeasurementApp.Quantity feet2 = new UC3_QuantityMeasurementApp.Quantity(2.0, UC3_QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(feet1.equals(feet2), "1.0 feet should not equal 2.0 feet");
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        UC3_QuantityMeasurementApp.Quantity inch1 = new UC3_QuantityMeasurementApp.Quantity(1.0, UC3_QuantityMeasurementApp.LengthUnit.INCH);
        UC3_QuantityMeasurementApp.Quantity inch2 = new UC3_QuantityMeasurementApp.Quantity(2.0, UC3_QuantityMeasurementApp.LengthUnit.INCH);
        assertFalse(inch1.equals(inch2), "1.0 inch should not equal 2.0 inch");
    }

    @Test
    public void testEquality_NullUnit() {
        // Validates that the null unit is handled appropriately (throws exception)
        assertThrows(IllegalArgumentException.class, () -> {
            new UC3_QuantityMeasurementApp.Quantity(1.0, null);
        }, "Instantiating with a null unit should throw an IllegalArgumentException");
    }

    @Test
    public void testEquality_SameReference() {
        UC3_QuantityMeasurementApp.Quantity quantity = new UC3_QuantityMeasurementApp.Quantity(1.0, UC3_QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(quantity.equals(quantity), "A Quantity object should equal itself");
    }

    @Test
    public void testEquality_NullComparison() {
        UC3_QuantityMeasurementApp.Quantity quantity = new UC3_QuantityMeasurementApp.Quantity(1.0, UC3_QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(quantity.equals(null), "Comparison with null should return false");
    }
}