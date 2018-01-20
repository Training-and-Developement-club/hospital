package TheDevineHospital.SortPackage;

import TheDevineHospital.EntityClasses.Patients.Patient;

import java.util.Comparator;

public class SortPatientByName implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        String name = o1.getFullName().get("Имя");
        String name1 = o2.getFullName().get("Имя");

        return name.compareTo(name1);
    }
}
