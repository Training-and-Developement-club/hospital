package hospital.manager.search;

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
        int total = 0;
        for (int i = 0; i < patientList.getPatients().size(); i++) {
            if((patientList.getPatients().get(i).getFullName().containsValue(doc))){
                System.out.println("Найдено совпадение " + patientList.getPatients().get(i).toString());
                total++;
            }

        }


        if (total == 0) {
            System.out.println("Совпадений не найдено");
        }

    }
}
