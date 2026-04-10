import java.util.*;
import java.util.function.Predicate;

public class UC12 {

    // Goods Bogie class
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    // Safety check method (important for testing)
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {

        // Rule: Cylindrical bogies must carry Petroleum
        Predicate<GoodsBogie> safetyRule = b ->
                !b.type.equalsIgnoreCase("Cylindrical") ||
                b.cargo.equalsIgnoreCase("Petroleum");

        return bogies.stream().allMatch(safetyRule);
    }

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("===============================================\n");

        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // unsafe

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(System.out::println);

        boolean isSafe = isTrainSafe(goodsBogies);

        System.out.println("\nSafety Compliance Status: " + isSafe);

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}