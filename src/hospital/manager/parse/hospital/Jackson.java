package hospital.manager.parse.hospital;

import hospital.entity.Hospital;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Десериализация json документа в java-обьект(Doctors) библиотекай Jackson
 * */
public class Jackson  {


    public Hospital parse(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        Hospital hospital = null;
        try {
            hospital = objectMapper.readValue(new File(fileName), Hospital.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        return hospital;
    }
}
