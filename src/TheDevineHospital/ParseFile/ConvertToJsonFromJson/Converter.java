package TheDevineHospital.ParseFile.ConvertToJsonFromJson;


import TheDevineHospital.EntityClasses.PatientList;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

/*
 * Для конвертации созданных обьектов в текстовый файл с расширением json.
 */
public class Converter {
    private static String fileName = "patient.json";


    /*
     *  Конвертация(или по java-вски сериализация) java-обьектов в файл с расширением json,
     * C помощью библиотеки Jackson.
     * */
    public static void converteToJson(PatientList patientList) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), patientList);

    }

    /*
     * Декоонвертация(или по java-вски десериализация) json-файла в java-обьект,
     * C помощью библиотеки Jackson.
     * */

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
