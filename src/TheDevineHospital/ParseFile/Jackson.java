package TheDevineHospital.ParseFile;

import TheDevineHospital.EntityClasses.Hospital;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson extends Parse{

    @Override
    public void parse(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Hospital hospital = objectMapper.readValue(new File(fileName), Hospital.class);
            System.out.println(hospital.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
