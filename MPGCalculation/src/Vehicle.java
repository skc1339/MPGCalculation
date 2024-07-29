
public class Vehicle implements Comparable<Vehicle> {
    private String make;
    private String model;
    private double milesPerGallon;

    public Vehicle(String make, String model, double milesPerGallon) {
        this.make = make;
        this.model = model;
        this.milesPerGallon = milesPerGallon;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getMilesPerGallon() {
        return milesPerGallon;
    }

    @Override
    public int compareTo(Vehicle other) {
        return Double.compare(this.milesPerGallon, other.milesPerGallon);
    }

    @Override
    public String toString() {
        return make + " " + model + " - " + milesPerGallon + " MPG";
    }
}





