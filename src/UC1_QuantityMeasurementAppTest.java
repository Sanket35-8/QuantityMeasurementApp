import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1_QuantityMeasurementAppTest {

    @Test
    public void testEquality_SameValue() {
        UC1_QuantityMeasurementApp.Feet feet1 = new UC1_QuantityMeasurementApp.Feet(1.0);
        UC1_QuantityMeasurementApp.Feet feet2 = new UC1_QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet1.equals(feet2), "1.0 ft should be equal to 1.0 ft");
    }

    @Test
    public void testEquality_DifferentValue() {
        UC1_QuantityMeasurementApp.Feet feet1 = new UC1_QuantityMeasurementApp.Feet(1.0);
        UC1_QuantityMeasurementApp.Feet feet2 = new UC1_QuantityMeasurementApp.Feet(2.0);
        assertFalse(feet1.equals(feet2), "1.0 ft should not be equal to 2.0 ft");
    }

    @Test
    public void testEquality_NullComparison() {
        UC1_QuantityMeasurementApp.Feet feet1 = new UC1_QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet1.equals(null), "Comparison with null should return false");
    }

    @Test
    public void testEquality_NonNumericInput() {
        UC1_QuantityMeasurementApp.Feet feet1 = new UC1_QuantityMeasurementApp.Feet(1.0);
        String nonNumeric = "1.0";
        assertFalse(feet1.equals(nonNumeric), "Comparison with non-Feet object should be false");
    }

    @Test
    public void testEquality_SameReference() {
        UC1_QuantityMeasurementApp.Feet feet1 = new UC1_QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet1.equals(feet1), "An object should be equal to itself");
    }
}