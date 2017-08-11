package com.tbell;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TelematicService {
    private VehicleInfo vehicleInfo;

    public TelematicService(){};

    public static void report(VehicleInfo vehicleInfo) {


        try {
            File file = new File(vehicleInfo.getVIN() + ".json");

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json);
            fileWriter.close();


            File newFile = new File(".");
            for (File f: newFile.listFiles()) {
                if (f.getName().endsWith(".json")) {
                    Scanner fileScanner = new Scanner(f);
                    String carInfo = fileScanner.nextLine();
                    VehicleInfo vi = mapper.readValue(json, VehicleInfo.class);

                    String viPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vi);
                    System.out.println("Car Telematcis for " + f.getName()  + viPretty );
                }
            }
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


}


