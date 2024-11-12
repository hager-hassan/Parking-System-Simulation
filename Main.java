package org.example;

import java.util.List;
import java.util.Map;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
          String filename = "Yarab.txt";
          ParkingLot MyPL =new ParkingLot(4);
          Inputparsing myinputparsing = new Inputparsing(filename, MyPL);
          Map<String, List<Car>> Mycars = myinputparsing.ParseInput();//kada m3ak map bt2ol kol gate feha which cars as a list

//            Gate gate1 = new Gate("Gate 1", Mycars.getOrDefault("Gate 1", List.of()));
//            Gate gate2 = new Gate("Gate 2", Mycars.getOrDefault("Gate 2", List.of()));
//            Gate gate3 = new Gate("Gate 3", Mycars.getOrDefault("Gate 3", List.of()));
//
//            gate1.start();
//            gate2.start();
//            gate3.start();
//
//            // Wait for all gate threads to finish
//            try {
//                gate1.join();
//                gate2.join();
//                gate3.join();
//            } catch (InterruptedException e) {
//                System.out.println("\033[0;31mSimulation interrupted.\033[0m");
//            }
//
//            // Final Report
//            System.out.println("\nSimulation complete. All cars have finished parking.");
    }
//          myinputparsing.printGateCarsMap(Mycars);
}
