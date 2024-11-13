package org.os;
import java.lang.InterruptedException;

// responsible for managing the available parking spaces using Semaphore,
// so that we can control the number of cars that can enter the parking spaces at the same time.


import java.util.concurrent.Semaphore;

public class ParkingLot {

    private Semaphore availableSpots; // at7km fe 3dd el spots el mota7a
    private int avaliableSpots; // store 3dd el spots el fadya
    private int occupiedSpots = 0; // store 3dd el spots el ma48ola


    public ParkingLot(int numberOfSpots) {
        this.avaliableSpots = numberOfSpots;
        this.availableSpots = new Semaphore(numberOfSpots); // ba initialize el semaphore be 3dd el spots el mota7a
    }

    public synchronized boolean parking(int carId, int gate){

        try{
            availableSpots.acquire(); // b7awl a5d mkan fe el parking
            occupiedSpots++; // increase 3dd el spots el m48ola

          //  System.out.println(carId + " from " + gate + " parked. (Parking Status: " + occupiedSpots + " spots occupied)");
            return true;
        }
        catch (InterruptedException e){
            System.out.println("\033[0;31m" + carId + " interrupted while waiting for a parking spot.\033[0m");
            return false;
        }

    }

    public synchronized void leaving(int carId, int gate){

        availableSpots.release(); // lma car tm4y hnfdy mkan fe el parking
        occupiedSpots--; // decrease 3dd el amaken el m48ola
       // System.out.println(carId + " from " + gate + " left after " + (occupiedSpots + 1) + " units of time. (Parking Status: " + occupiedSpots + " spots occupied)");
    }

    public int getOccupiedSpots() {
        return occupiedSpots; // return 3dd el spots el m48ola
    }

    public int getAvaliableSpots() {
        return avaliableSpots; // return 3dd el spots mota7a
    }

}
