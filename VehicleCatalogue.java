import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    static class Vehicle {
        String typeOfVehicle;
        String model;
        String color;
        int horsePower;

        Vehicle (String typeOfVehicle, String model, String color, int horsePower) {
            this.typeOfVehicle = typeOfVehicle;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }


        public String getModel () {

            return  this.model;
        }

        public double getHorsePower () {

            return this.horsePower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",typeOfVehicle.substring(0,1).toUpperCase() + typeOfVehicle.substring(1).toLowerCase(), model, color, horsePower);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Vehicle> allVehicles = new ArrayList<>();
        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> trucks = new ArrayList<>();
        while (!input.equals("End")) {
            String[] temp = input.split("\\s+");
            String typeOfVehicle = temp[0];
            String model = temp[1];
            String color = temp[2];
            int horsePower = Integer.parseInt(temp[3]);

            Vehicle vehicles = new Vehicle(typeOfVehicle, model, color, horsePower);

            if (typeOfVehicle.equals("car")) {
                cars.add(vehicles);
            } else {
                trucks.add(vehicles);
            }

            allVehicles.add(vehicles);

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("Close the Catalogue")) {
            for (Vehicle vehicle : allVehicles) {
                if (command.equals(vehicle.getModel())) {
                    System.out.println(vehicle);
                }
            }
            command = scanner.nextLine();
        }

        double avgCars = 0;
        if(cars.isEmpty()){
            System.out.println("Cars have average horsepower of: 0.00.");
        }else {
            for (Vehicle car : cars) {
                avgCars += car.getHorsePower();
            }

            System.out.println(String.format("Cars have average horsepower of: %.2f.", avgCars / cars.size()));
        }
        double truckAvg = 0;

        if(trucks.isEmpty()){
            System.out.println("Trucks have average horsepower of: 0.00.");
        }else {
            for (Vehicle truck : trucks) {
                truckAvg += truck.getHorsePower();
            }

            System.out.println(String.format("Trucks have average horsepower of: %.2f.", truckAvg / trucks.size()));
        }
    }
}