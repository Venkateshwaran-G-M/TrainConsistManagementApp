import java.util.*;

public class UC10 {

    
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }
    public static int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("========================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display bogies
        System.out.println("Bogies in Train:");
        bogies.forEach(System.out::println);

        // Calculate total
        int total = calculateTotalCapacity(bogies);

        System.out.println("\nTotal Seating Capacity of Train: " + total);
        System.out.println("\nUC10 aggregation completed...");
    }
}