public class UC2_QuantityMeasurementApp {

    // The Feet class (Same as UC1)
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet otherFeet = (Feet) obj;
            return Double.compare(this.value, otherFeet.value) == 0;
        }
    }

    // Step 1: Separate Inches class, practically identical to Feet (Violates DRY principle)
    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Inches otherInches = (Inches) obj;
            return Double.compare(this.value, otherInches.value) == 0;
        }
    }

    // Step 3: Separate static methods to reduce dependency on the main method
    public static boolean checkFeetEquality(double val1, double val2) {
        Feet feet1 = new Feet(val1);
        Feet feet2 = new Feet(val2);
        return feet1.equals(feet2);
    }

    public static boolean checkInchesEquality(double val1, double val2) {
        Inches inch1 = new Inches(val1);
        Inches inch2 = new Inches(val2);
        return inch1.equals(inch2);
    }

    // Main Method
    public static void main(String[] args) {
        // Step 2: Compare inches and print results
        boolean inchResult = checkInchesEquality(1.0, 1.0);
        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + inchResult + ")");

        // Compare feet and print results
        boolean feetResult = checkFeetEquality(1.0, 1.0);
        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + feetResult + ")");
    }
}