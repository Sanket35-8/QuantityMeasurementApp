public class UC4_QuantityMeasurementApp {

    // Step 1: Update LengthUnit Enum with YARDS and CENTIMETERS
    public enum LengthUnit {
        FEET(12.0),           // 1 Foot = 12 Inches
        INCH(1.0),            // Base unit
        YARDS(36.0),          // 1 Yard = 3 Feet = 36 Inches
        CENTIMETERS(0.393701); // 1 CM = 0.393701 Inches

        public final double baseConversionFactor;

        LengthUnit(double baseConversionFactor) {
            this.baseConversionFactor = baseConversionFactor;
        }
    }

    // Step 2: Verify QuantityLength Class (Generic design handles the new units automatically)
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity otherQuantity = (Quantity) obj;

            // Convert both measurements to base unit (inches)
            double thisBaseValue = this.value * this.unit.baseConversionFactor;
            double otherBaseValue = otherQuantity.value * otherQuantity.unit.baseConversionFactor;

            // Round to 5 decimal places to handle precision issues with 0.393701 cm conversions
            double roundedThis = Math.round(thisBaseValue * 100000.0) / 100000.0;
            double roundedOther = Math.round(otherBaseValue * 100000.0) / 100000.0;

            return Double.compare(roundedThis, roundedOther) == 0;
        }
    }

    public static void main(String[] args) {
        // Output examples requested in UC4
        Quantity oneYard = new Quantity(1.0, LengthUnit.YARDS);
        Quantity threeFeet = new Quantity(3.0, LengthUnit.FEET);
        System.out.println("Input: Quantity(1.0, YARDS) and Quantity(3.0, FEET)");
        System.out.println("Output: Equal (" + oneYard.equals(threeFeet) + ")");

        Quantity thirtySixInches = new Quantity(36.0, LengthUnit.INCH);
        System.out.println("Input: Quantity(1.0, YARDS) and Quantity(36.0, INCHES)");
        System.out.println("Output: Equal (" + oneYard.equals(thirtySixInches) + ")");

        Quantity oneCm = new Quantity(1.0, LengthUnit.CENTIMETERS);
        Quantity cmToInches = new Quantity(0.393701, LengthUnit.INCH);
        System.out.println("Input: Quantity(1.0, CENTIMETERS) and Quantity(0.393701, INCHES)");
        System.out.println("Output: Equal (" + oneCm.equals(cmToInches) + ")");
    }
}
