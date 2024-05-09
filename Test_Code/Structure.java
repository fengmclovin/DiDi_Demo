import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String phoneNumber;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class Driver {
    private String name;
    private String carModel;

    public Driver(String name, String carModel) {
        this.name = name;
        this.carModel = carModel;
    }

    public String getName() {
        return name;
    }

    public String getCarModel() {
        return carModel;
    }
}

class Ride {
    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    public Ride(User user, Driver driver, double distance) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = calculateFare();
    }

    private double calculateFare() {
        // Simplified fare calculation based on distance
        return distance * 0.5;  // Assuming $0.50 per kilometer
    }

    public double getFare() {
        return fare;
    }

    public void printRideDetails() {
        System.out.println("User: " + user.getName());
        System.out.println("Driver: " + driver.getName() + " - Car Model: " + driver.getCarModel());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: $" + fare);
    }
}

class RideshareApp {
    private List<User> users;
    private List<Driver> drivers;

    public RideshareApp() {
        this.users = new ArrayList<>();
        this.drivers = new ArrayList<>();
    }

    public void registerUser(String name, String phoneNumber) {
        User user = new User(name, phoneNumber);
        users.add(user);
        System.out.println("User " + name + " registered successfully!");
    }

    public void registerDriver(String name, String carModel) {
        Driver driver = new Driver(name, carModel);
        drivers.add(driver);
        System.out.println("Driver " + name + " registered successfully!");
    }

    public Ride requestRide(User user, double distance) {
        if (drivers.isEmpty()) {
            System.out.println("No drivers available. Please try again later.");
            return null;
        }

        Driver driver = drivers.get(0);  // Simplified: Assign the first available driver
        Ride ride = new Ride(user, driver, distance);
        System.out.println("Ride requested successfully!");
        return ride;
    }
}

public class Main {
    public static void main(String[] args) {
        RideshareApp app = new RideshareApp();

        // Register users and drivers
        app.registerUser("Alice", "123-456-7890");
        app.registerUser("Bob", "987-654-3210");
        app.registerDriver("John", "Toyota Corolla");
        app.registerDriver("Emily", "Honda Civic");

        // Request a ride
        User user = app.users.get(0);  // Assume Alice is the user
        Ride ride = app.requestRide(user, 10);  // 10 kilometers distance
        if (ride != null) {
            ride.printRideDetails();
        }
    }
}
