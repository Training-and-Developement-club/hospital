package TheDevineHospital.SearchPackage;

import TheDevineHospital.EntityClasses.Patients.PatientList;
import TheDevineHospital.InputAndOutputText.HelpInput;

public class SearchPatientByName {
    public static void search() {
        PatientList patientList = PatientList.getInstance();

        if (patientList.equals(null)) {
            System.err.println("Объект Hospital не найден");
            return;
        }

        System.out.println("Введите имя пациента:");
        String doc = HelpInput.inputString();
        int registor = 0;
        for (int i = 0; i < patientList.getPatients().size(); i++) {
            if (doc.equalsIgnoreCase(patientList.getPatients().get(i).getName())) {
                System.out.println("Найден пациент - " + patientList.getPatients().get(i).toString());
                registor++;
            } else if (patientList.getPatients().get(i).getName().contains(doc)) {
                System.out.println("Есть совпадение - " + patientList.getPatients().get(i).toString());
                registor++;
            }

        }


        if (registor == 0) {
            System.out.println("Совпадений не найдено");
        }

    }
}
