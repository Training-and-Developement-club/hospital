package TheDevineHospital.ParseFile;

import TheDevineHospital.EntityClasses.Hospital;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;

public class GsonParser extends Parse {

    @Override
    public void parse(String filaName) {
        try{
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(filaName));
            GsonBuilder gsonBuilder = new GsonBuilder();
            com.google.gson.Gson gson = gsonBuilder.create();
            Hospital hospital = gson.fromJson(bufferedReader,Hospital.class);//
            System.out.println(hospital.toString());


        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
