package com.tbell;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("Telematics 3000");
        Scanner scanner = new Scanner(System.in);
        System.out.print("VIN: ");
        int VIN = scanner.nextInt();
        System.out.print("Odometer(miles traveled): ");
        double odom = scanner.nextDouble();
        System.out.print("Consumption (gallons of gas consumed): ");
        double consump = scanner.nextDouble();
        System.out.print("Last oil change odometer reading: ");
        double oilReading = scanner.nextDouble();
        System.out.print("Engine Size: ");
        double engineSize = scanner.nextDouble();

        VehicleInfo newVehicle = new VehicleInfo();
        newVehicle.setVIN(VIN);
        newVehicle.setOdometer(odom);
        newVehicle.setConsumption(consump);
        newVehicle.setLastOilChange(oilReading);
        newVehicle.setEngineSize(engineSize);

        TelematicService telematcis = new TelematicService();
        telematcis.report(newVehicle);
    }
}
