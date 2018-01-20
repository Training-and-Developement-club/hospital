package TheDevineHospital.SearchPackage;

import TheDevineHospital.EntityClasses.Patients.Patient;
import TheDevineHospital.InputText.HelpInput;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class SearchPatientByDate {

    private static Date date;
    private static final  String  TIMEZONE_UTC  = "UTC";

    public static void search(List<Patient> peopleList) {
        date = HelpInput.inputDate();
        SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS z");
        TimeZone timeZone = TimeZone.getTimeZone(TIMEZONE_UTC);
        spd.setTimeZone(timeZone);
        int counter = 0;
        for(int i = 0;i<peopleList.size();i++){
            if(peopleList.get(i).getDateOfBirth().equals(date)){
                System.out.println("По вашему запросу есть совпадение " + peopleList.get(i).toString());
                counter++;
            }
            if(i==peopleList.size()-1 && counter==0){
                System.out.println("По вашему запросу никто не найден.");
            }

        }
    }
}
