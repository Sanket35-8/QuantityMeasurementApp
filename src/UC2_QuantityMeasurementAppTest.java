import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC2_QuantityMeasurementAppTest {

    // ================= FEET TESTS =================

    @Test
    public void testFeetEquality_SameValue() {
        UC2_QuantityMeasurementApp.Feet feet1 = new UC2_QuantityMeasurementApp.Feet(1.0);
        UC2_QuantityMeasurementApp.Feet feet2 = new UC2_QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet1.equals(feet2), "1.0 ft should equal 1.0 ft");
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        UC2_QuantityMeasurementApp.Feet feet1 = new UC2_QuantityMeasurementApp.Feet(1.0);
        UC2_QuantityMeasurementApp.Feet feet2 = new UC2_QuantityMeasurementApp.Feet(2.0);
        assertFalse(feet1.equals(feet2), "1.0 ft should not equal 2.0 ft");
    }

    @Test
    public void testFeetEquality_NullComparison() {
        UC2_QuantityMeasurementApp.Feet feet1 = new UC2_QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet1.equals(null), "Comparison with null should return false");
    }

    @Test
    public void testFeetEquality_NonNumericInput() {
        UC2_QuantityMeasurementApp.Feet feet1 = new UC2_QuantityMeasurementApp.Feet(1.0);
        String nonNumeric = "1.0";
        assertFalse(feet1.equals(nonNumeric), "Comparison with non-Feet object should be false");
    }

    @Test
    public void testFeetEquality_SameReference() {
        UC2_QuantityMeasurementApp.Feet feet1 = new UC2_QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet1.equals(feet1), "An object should equal itself");
    }

    // ================= INCHES TESTS =================

    @Test
    public void testInchesEquality_SameValue() {
        UC2_QuantityMeasurementApp.Inches inch1 = new UC2_QuantityMeasurementApp.Inches(1.0);
        UC2_QuantityMeasurementApp.Inches inch2 = new UC2_QuantityMeasurementApp.Inches(1.0);
        assertTrue(inch1.equals(inch2), "1.0 inch should equal 1.0 inch");
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        UC2_QuantityMeasurementApp.Inches inch1 = new UC2_QuantityMeasurementApp.Inches(1.0);
        UC2_QuantityMeasurementApp.Inches inch2 = new UC2_QuantityMeasurementApp.Inches(2.0);
        assertFalse(inch1.equals(inch2), "1.0 inch should not equal 2.0 inch");
    }

    @Test
    public void testInchesEquality_NullComparison() {
        UC2_QuantityMeasurementApp.Inches inch1 = new UC2_QuantityMeasurementApp.Inches(1.0);
        assertFalse(inch1.equals(null), "Comparison with null should return false");
    }

    @Test
    public void testInchesEquality_NonNumericInput() {
        UC2_QuantityMeasurementApp.Inches inch1 = new UC2_QuantityMeasurementApp.Inches(1.0);
        String nonNumeric = "1.0";
        assertFalse(inch1.equals(nonNumeric), "Comparison with non-Inches object should be false");
    }

    @Test
    public void testInchesEquality_SameReference() {
        UC2_QuantityMeasurementApp.Inches inch1 = new UC2_QuantityMeasurementApp.Inches(1.0);
        assertTrue(inch1.equals(inch1), "An object should equal itself");
    }
}