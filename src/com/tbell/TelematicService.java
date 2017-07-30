package com.tbell;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TelematicService {
    private VehicleInfo vehicleInfo;

    public TelematicService(){};

    public void report(VehicleInfo vehicleInfo){

        try {
            int vin = vehicleInfo.getVIN();
            String filename = vin + ".json";

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);

            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json);
            fileWriter.close();

        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("File not created.");
        }

    }
    public void backToObject () throws IOException{
        File file = new File(".");
        VehicleInfo vi = null;
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                new FileReader(f);
                ObjectMapper mapper = new ObjectMapper();
                vi = mapper.readValue(f, VehicleInfo.class);

            }
        }
    }
}


