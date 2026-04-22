public class UC5_QuantityMeasurementApp {

    // Enum representing length units and their base conversion factors (Base: Inches)
    public enum LengthUnit {
        FEET(12.0),
        INCH(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        public final double baseConversionFactor;

        LengthUnit(double baseConversionFactor) {
            this.baseConversionFactor = baseConversionFactor;
        }
    }

    /**
     * Immutable Quantity class representing a measurement.
     */
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");

            this.value = value;
            this.unit = unit;
        }

        public double getValue() { return value; }
        public LengthUnit getUnit() { return unit; }

        /**
         * Instance method to convert this quantity to a new target unit.
         */
        public Quantity convertTo(LengthUnit targetUnit) {
            double convertedValue = convert(this.value, this.unit, targetUnit);
            return new Quantity(convertedValue, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;
            double thisBaseValue = this.value * this.unit.baseConversionFactor;
            double otherBaseValue = other.value * other.unit.baseConversionFactor;

            // Using an epsilon for precise floating-point comparison
            return Math.abs(thisBaseValue - otherBaseValue) < 0.00001;
        }

        @Override
        public String toString() {
            return "Quantity{" + "value=" + value + ", unit=" + unit + '}';
        }
    }

    /**
     * Public API: Converts a numeric value from a source unit to a target unit.
     * @param value numeric value to convert
     * @param source source unit
     * @param target target unit
     * @return converted numeric value
     * @throws IllegalArgumentException for null units or non-finite values
     */
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }

        // Convert to base unit (inches), then divide by target conversion factor
        double baseValue = value * source.baseConversionFactor;
        return baseValue / target.baseConversionFactor;
    }

    // ================= API DESIGN: Overloaded Demonstration Methods =================

    public static void demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        double result = convert(value, fromUnit, toUnit);
        System.out.println("Input: convert(" + value + ", " + fromUnit + ", " + toUnit + ") -> Output: " + result);
    }

    public static void demonstrateLengthConversion(Quantity length, LengthUnit toUnit) {
        Quantity converted = length.convertTo(toUnit);
        System.out.println("Input: convert object " + length + " to " + toUnit + " -> Output: " + converted);
    }

    public static void main(String[] args) {
        // Output examples requested in UC5
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCH);
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCH, LengthUnit.YARDS);

        // Centimeters result in a long decimal, so we demonstrate the raw return
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCH);
        demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCH);

        // Demonstrating the overloaded method
        Quantity yardMeasurement = new Quantity(2.0, LengthUnit.YARDS);
        demonstrateLengthConversion(yardMeasurement, LengthUnit.FEET);
    }
}