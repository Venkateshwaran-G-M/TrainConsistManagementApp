public class UC14 {

    // Custom Exception
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie class with validation
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("=======================================\n");

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + b1);

            // Invalid case
            PassengerBogie b2 = new PassengerBogie("General", 0);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}