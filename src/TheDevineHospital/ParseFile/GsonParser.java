package TheDevineHospital.ParseFile;

import TheDevineHospital.EntityClasses.Hospital;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
/*
* @return Этот класс используется библиотеку от Google - GSON.
* Выйгрывает по скорости у всех при парсинге большого кол-ва маленьких Json - файлов, но для больших в каталоге есть Jackson.
* */
public class GsonParser extends Parse {

    @Override
    public Hospital parse(String filaName) {
        Hospital hospital = null;
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(filaName));
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            hospital = gson.fromJson(bufferedReader, Hospital.class);//
            System.out.println(hospital.toString());


        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        System.out.println(hospital.toString());
        return hospital;
    }
}
