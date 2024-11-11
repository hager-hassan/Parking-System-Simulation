package org.os;
import java.util.concurrent.Semaphore;
//LESA HA3ADEL FEEEEHHHHHHHHH

public class Gate implements Runnable {
    private final String gateNumber;
    private final Semaphore gateSemaphore; // so that 2 cars cannot go through the same gate at the same time
    private final ParkingLot parkingLot;
    private final String[][] carSchedule;// for arrivals

    public Gate(String gateNumber, ParkingLot parkingLot, String[][] carSchedule) {

        if (!isValidGate(gateNumber)) {// if gaate number is more than 3 and less than 1
            System.out.println("\033[0;31mError: " + gateNumber + " is not a valid gate.\033[0m");
            throw new IllegalArgumentException("Invalid gate: " + gateNumber);
        }

        this.gateNumber = gateNumber;
        this.parkingLot = parkingLot;
        this.gateSemaphore = new Semaphore(1, true);//if true dakhal 1
        this.carSchedule = carSchedule;
    }
    private boolean isValidGate(String gateNumber) {
        return gateNumber.equals("Gate 1") || gateNumber.equals("Gate 2") || gateNumber.equals("Gate 3");
    }
    @Override
    public void run() {
        for (String[] car : carSchedule) {
            String carId = car[0];
            int arriveTime = Integer.parseInt(car[1]);
            int parkDuration = Integer.parseInt(car[2]);

            try {
                Thread.sleep(arriveTime * 1000L); //pause a second then dakhal el ba3do

                gateSemaphore.acquire(); // One car enters gate at a time
                System.out.println(carId + " is passing through " + gateNumber);

                parkingLot.parking(carId, gateNumber); // Try parking
                Thread.sleep(parkDuration * 1000L); // Simulate parking duration
                parkingLot.leaving(carId, gateNumber); // Leave parking

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("\033[0;31m" + carId + " interrupted at " + gateNumber + ".\033[0m");
            } finally {
                gateSemaphore.release(); // Next car can pass through the gate
            }
        }
    }

}
