package org.example;
//Menna
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Inputparsing {
    private final String inputfile;
    private final ParkingLot PL;

    Inputparsing(String inputfile, ParkingLot PL) {
        this.inputfile = inputfile;
        this.PL = PL;
    }

    public Map<String, List<Car>> ParseInput() {
        Map<String, List<Car>> MyCars = new HashMap<>();

        try(BufferedReader myreader = new BufferedReader(new FileReader(inputfile))){
           String line;
           while ((line = myreader.readLine()) != null) {
               String[] parts = line.split(", ");
               String gate = parts[0];
               String carId = parts[1];
               int arrivalTime = Integer.parseInt(parts[2].split(" ")[1]);// htb2a b3d al split {"Arrive","time"} then take part index 1 al time ya3ny w hwalo mn string la int
               int parkingDuration = Integer.parseInt(parts[3].split(" ")[1]);//zay al ablha {"Parks","time"} then take time only
               Car newcar = new Car(carId, gate, arrivalTime, parkingDuration, PL);
               MyCars.computeIfAbsent(gate, f -> new ArrayList<>()).add(newcar);//lw al gate dehh lasa m4 mawgowda e3mlha key then e3ml list kman leha
               //law mawgowda roh lal gate dehh w add your car in the list
               //gate1 : car1->car2->car3.....
           }
        }
        catch (IOException e) {
            System.out.println("\033[0;31mError reading file: " + e.getMessage() + "\033[0m");
        }
        return MyCars;
    }

//    public void printGateCarsMap(Map<String, List<Car>> gateCarsMap) {
//        for (String gate : gateCarsMap.keySet()) {
//            System.out.println("Gate: " + gate);
//
//            List<Car> cars = gateCarsMap.get(gate);
//            for (Car car : cars) {
//                System.out.println("    Car ID: " + car.getCarId() +
//                        ", Arrival Time: " + car.getArrivalTime() +
//                        ", Parking Duration: " + car.getParkingDuration());
//            }
//
//            System.out.println(); // Blank line for readability between gates
//        }
//    }
}
