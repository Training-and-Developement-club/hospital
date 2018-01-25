package TheDevineHospital.EntityClasses.Patients;

import java.util.Calendar;
import java.util.Date;
/**
 * Вычисляет текущий возраст пациента по дате рождения
 * */
public class CalculatePatientsAge {
    public static int totalAge(Date date){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.setTime(date);
        dob.add(Calendar.DAY_OF_MONTH, -1);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }
}
