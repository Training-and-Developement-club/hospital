package TheDevineHospital.ParseFile.ConvertToJsonFromJson;


import TheDevineHospital.EntityClasses.Patients.PatientList;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

//Конвертация обьекта в файл и обратно с помощью библы Jackson
public class Converter {
    private static String fileName = "patient.json";


   
    public static void converteToJson(PatientList patientList) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), patientList);

    }

    

    public static PatientList converterFromJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), PatientList.class);

    }

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        Converter.fileName = fileName;
    }
}
