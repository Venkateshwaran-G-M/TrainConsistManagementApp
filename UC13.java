import java.util.*;
import java.util.stream.Collectors;

public class UC13 {

    // Bogie class
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    // Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("=======================================\n");

        List<Bogie> bogies = new ArrayList<>();

        // Create large dataset
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Type" + i, i % 100));
        }

        // Loop timing
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterUsingLoop(bogies);
        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // Stream timing
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterUsingStream(bogies);
        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // Output
        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}