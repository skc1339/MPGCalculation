
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class VehicleDataCollector {
    public static void main(String[] args) {
        LinkedList<Vehicle> vehicleList = new LinkedList<>();
        try (Scanner scanner = new Scanner(System.in)) {
			String input;

			while (true) {
			    System.out.print("Enter vehicle make (or type 'done' to finish): ");
			    input = scanner.nextLine();
			    if (input.equalsIgnoreCase("done")) break;
			    String make = input;

			    System.out.print("Enter vehicle model: ");
			    String model = scanner.nextLine();

			    double mpg = 0;
			    while (true) {
			        try {
			            System.out.print("Enter miles per gallon: ");
			            mpg = Double.parseDouble(scanner.nextLine());
			            if (mpg <= 0) throw new NumberFormatException();
			            break;
			        } catch (NumberFormatException e) {
			            System.out.println("Please enter a valid positive number for miles per gallon.");
			        }
			    }

			    vehicleList.add(new Vehicle(make, model, mpg));
			}
		}
        vehicleList.sort(null); // Sort the list by miles per gallon

        saveToTextFile(vehicleList, "vehicle_data.txt");
    }

    private static void saveToTextFile(LinkedList<Vehicle> vehicleList, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Vehicle vehicle : vehicleList) {
                writer.println(vehicle);
            }
            System.out.println("Vehicle data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}




