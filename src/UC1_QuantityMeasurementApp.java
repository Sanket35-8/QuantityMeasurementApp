public class UC1_QuantityMeasurementApp {

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

    public static void main(String[] args) {
        Feet length1 = new Feet(1.0);
        Feet length2 = new Feet(1.0);
        boolean result = length1.equals(length2);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + result + ")");
    }
}