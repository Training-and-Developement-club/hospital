package hospital.search;

import hospital.entity.Patients.PatientList;
import hospital.input.HelpInput;
/**
 *  Поиск пациентов по имени
 */
public class SearchPatientByName {
    public static void search() {
        PatientList patientList = PatientList.getInstance();
        System.out.println("Введите имя пациента:");
        String doc = HelpInput.inputString();
        int registor = 0;
        for (int i = 0; i < patientList.getPatients().size(); i++) {
            if (doc.equalsIgnoreCase(patientList.getPatients().get(i).getName())) {
                System.out.println("Найден пациент - " + patientList.getPatients().get(i).toString());
                registor++;
            } else if (patientList.getPatients().get(i).getName().toLowerCase().contains(doc.toLowerCase())) {
                System.out.println("Есть совпадение - " + patientList.getPatients().get(i).toString());
                registor++;
            }

        }


        if (registor == 0) {
            System.out.println("Совпадений не найдено");
        }

    }
}
