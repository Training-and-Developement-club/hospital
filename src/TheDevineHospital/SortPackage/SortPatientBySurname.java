package TheDevineHospital.SortPackage;

import TheDevineHospital.EntityClasses.Patients.Patient;

import java.util.Comparator;
/**
 * Интерфейс для упорядочивания обьектов класса Patient по фамилии
 * */
public class SortPatientBySurname implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        String name = o1.getFullName().get("Фамилия");
        String name1 = o2.getFullName().get("Фамилия");

        return name.compareTo(name1);
    }
}
