public class UC3_QuantityMeasurementApp {

    // Step 1: Enum to handle multiple unit types and their conversion factors
    public enum LengthUnit {
        FEET(12.0), // 1 Foot = 12 Inches
        INCH(1.0);  // Base unit

        public final double baseConversionFactor;

        LengthUnit(double baseConversionFactor) {
            this.baseConversionFactor = baseConversionFactor;
        }
    }

    // Step 2: Generic Quantity Class applying the DRY Principle
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            // Null Safety and Type Safety for units
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {
            // Reflexive property
            if (this == obj) return true;

            // Null comparison and Type checking
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity otherQuantity = (Quantity) obj;

            // Convert both measurements to the base unit (inches) for comparison
            double thisBaseValue = this.value * this.unit.baseConversionFactor;
            double otherBaseValue = otherQuantity.value * otherQuantity.unit.baseConversionFactor;

            return Double.compare(thisBaseValue, otherBaseValue) == 0;
        }
    }

    public static void main(String[] args) {
        // Test cross-unit comparison
        Quantity oneFoot = new Quantity(1.0, LengthUnit.FEET);
        Quantity twelveInches = new Quantity(12.0, LengthUnit.INCH);

        System.out.println("Input: Quantity(1.0, \"feet\") and Quantity(12.0, \"inches\")");
        System.out.println("Output: Equal (" + oneFoot.equals(twelveInches) + ")");

        // Test same-unit comparison
        Quantity oneInch1 = new Quantity(1.0, LengthUnit.INCH);
        Quantity oneInch2 = new Quantity(1.0, LengthUnit.INCH);

        System.out.println("Input: Quantity(1.0, \"inch\") and Quantity(1.0, \"inch\")");
        System.out.println("Output: Equal (" + oneInch1.equals(oneInch2) + ")");
    }
}
