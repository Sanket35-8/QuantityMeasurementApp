import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC4_QuantityMeasurementAppTest {

    // ================= YARDS TESTS =================

    @Test
    public void testEquality_YardToYard_SameValue() {
        UC4_QuantityMeasurementApp.Quantity yard1 = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        UC4_QuantityMeasurementApp.Quantity yard2 = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        assertTrue(yard1.equals(yard2), "1.0 yard should equal 1.0 yard");
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        UC4_QuantityMeasurementApp.Quantity yard1 = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        UC4_QuantityMeasurementApp.Quantity yard2 = new UC4_QuantityMeasurementApp.Quantity(2.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        assertFalse(yard1.equals(yard2), "1.0 yard should not equal 2.0 yards");
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        UC4_QuantityMeasurementApp.Quantity yard = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        UC4_QuantityMeasurementApp.Quantity feet = new UC4_QuantityMeasurementApp.Quantity(3.0, UC4_QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(yard.equals(feet), "1.0 yard should equal 3.0 feet");
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        UC4_QuantityMeasurementApp.Quantity feet = new UC4_QuantityMeasurementApp.Quantity(3.0, UC4_QuantityMeasurementApp.LengthUnit.FEET);
        UC4_QuantityMeasurementApp.Quantity yard = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        assertTrue(feet.equals(yard), "3.0 feet should equal 1.0 yard (Symmetry)");
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        UC4_QuantityMeasurementApp.Quantity yard = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        UC4_QuantityMeasurementApp.Quantity inches = new UC4_QuantityMeasurementApp.Quantity(36.0, UC4_QuantityMeasurementApp.LengthUnit.INCH);
        assertTrue(yard.equals(inches), "1.0 yard should equal 36.0 inches");
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        UC4_QuantityMeasurementApp.Quantity inches = new UC4_QuantityMeasurementApp.Quantity(36.0, UC4_QuantityMeasurementApp.LengthUnit.INCH);
        UC4_QuantityMeasurementApp.Quantity yard = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        assertTrue(inches.equals(yard), "36.0 inches should equal 1.0 yard (Symmetry)");
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        UC4_QuantityMeasurementApp.Quantity yard = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        UC4_QuantityMeasurementApp.Quantity feet = new UC4_QuantityMeasurementApp.Quantity(2.0, UC4_QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(yard.equals(feet), "1.0 yard should not equal 2.0 feet");
    }

    // ================= CENTIMETERS TESTS =================

    @Test
    public void testEquality_centimetersToInches_EquivalentValue() {
        UC4_QuantityMeasurementApp.Quantity cm = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.CENTIMETERS);
        UC4_QuantityMeasurementApp.Quantity inches = new UC4_QuantityMeasurementApp.Quantity(0.393701, UC4_QuantityMeasurementApp.LengthUnit.INCH);
        assertTrue(cm.equals(inches), "1.0 cm should equal 0.393701 inches");
    }

    @Test
    public void testEquality_centimetersToFeet_NonEquivalentValue() {
        UC4_QuantityMeasurementApp.Quantity cm = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.CENTIMETERS);
        UC4_QuantityMeasurementApp.Quantity feet = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(cm.equals(feet), "1.0 cm should not equal 1.0 feet");
    }

    // ================= MULTI-UNIT & EDGE CASE TESTS =================

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        UC4_QuantityMeasurementApp.Quantity yard = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        UC4_QuantityMeasurementApp.Quantity feet = new UC4_QuantityMeasurementApp.Quantity(3.0, UC4_QuantityMeasurementApp.LengthUnit.FEET);
        UC4_QuantityMeasurementApp.Quantity inches = new UC4_QuantityMeasurementApp.Quantity(36.0, UC4_QuantityMeasurementApp.LengthUnit.INCH);

        // Transitive check: A=B and B=C therefore A=C
        assertTrue(yard.equals(feet), "A should equal B");
        assertTrue(feet.equals(inches), "B should equal C");
        assertTrue(yard.equals(inches), "Therefore A should equal C");
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        UC4_QuantityMeasurementApp.Quantity yard = new UC4_QuantityMeasurementApp.Quantity(2.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        UC4_QuantityMeasurementApp.Quantity feet = new UC4_QuantityMeasurementApp.Quantity(6.0, UC4_QuantityMeasurementApp.LengthUnit.FEET);
        UC4_QuantityMeasurementApp.Quantity inches = new UC4_QuantityMeasurementApp.Quantity(72.0, UC4_QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(yard.equals(feet) && yard.equals(inches), "2 Yards should equal 6 Feet and 72 Inches");
    }

    @Test
    public void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UC4_QuantityMeasurementApp.Quantity(1.0, null);
        });
    }

    @Test
    public void testEquality_YardSameReference() {
        UC4_QuantityMeasurementApp.Quantity yard = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        assertTrue(yard.equals(yard), "Yard object should equal itself");
    }

    @Test
    public void testEquality_YardNullComparison() {
        UC4_QuantityMeasurementApp.Quantity yard = new UC4_QuantityMeasurementApp.Quantity(1.0, UC4_QuantityMeasurementApp.LengthUnit.YARDS);
        assertFalse(yard.equals(null), "Yard object should not equal null");
    }
}