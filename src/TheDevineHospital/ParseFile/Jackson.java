package TheDevineHospital.ParseFile;

import TheDevineHospital.EntityClasses.Hospital;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson extends Parse{

    @Override
    public Hospital parse(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        Hospital hospital = null;
        try {
            hospital = objectMapper.readValue(new File(fileName), Hospital.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hospital;
    }
}
