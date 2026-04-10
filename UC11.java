import java.util.Scanner;
import java.util.regex.Pattern;

public class UC11 {

    // Validation methods (important for testing)
    public static boolean isValidTrainId(String trainId) {
        String trainRegex = "TRN-\\d{4}";
        return Pattern.matches(trainRegex, trainId);
    }

    public static boolean isValidCargoCode(String cargoCode) {
        String cargoRegex = "PET-[A-Z]{2}";
        return Pattern.matches(cargoRegex, cargoCode);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("=======================================\n");

        // Input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Validation
        boolean isTrainValid = isValidTrainId(trainId);
        boolean isCargoValid = isValidCargoCode(cargoCode);

        // Output
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        System.out.println("\nUC11 validation completed...");
    }
}