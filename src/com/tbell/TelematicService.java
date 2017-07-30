package com.tbell;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TelematicService {

    public TelematicService(){};

    public void report(VehicleInfo vehicleInfo){
int vin = vehicleInfo.getVIN();
String filename = vin + ".json";
        try {
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("VIN: " + vehicleInfo.getVIN() + "\n");
            fileWriter.write("Odometer: " + vehicleInfo.getOdometer() + "\n");//Very simple!
            fileWriter.write("Consumption: " + vehicleInfo.getConsumption() + "\n");
            fileWriter.write("Last Oil Change OdometerReading: " + vehicleInfo.getLastOilChange() + "\n");
            fileWriter.write("Engine Size: " + vehicleInfo.getEngineSize() + "\n");
            fileWriter.close(); //close() cleans up and commits changes
        } //If Java doesn't find the file it will create it for us
        catch (IOException ex) { //A general exception that covers many errors
            ex.printStackTrace();
            System.out.println("File not created.");
        }
    }

}
