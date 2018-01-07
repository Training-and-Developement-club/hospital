package TheDevineHospital.EntityClasses;

import java.util.List;
import java.util.Objects;



/*
* @return Здесь, в (List<Patient> patients) хранится список всех пациентов, которые уже есть и которых вы ещё не добавили)
*/
public class PatientList {

    private List<TheDevineHospital.EntityClasses.Patient> patients;

    public List<TheDevineHospital.EntityClasses.Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<TheDevineHospital.EntityClasses.Patient> patients) {
        this.patients = patients;
    }

    public PatientList() {
    }



    @Override
    public String toString() {
        return "PatientList{" +
                "patients=" + patients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientList)) return false;
        PatientList that = (PatientList) o;
        return Objects.equals(patients, that.patients);
    }

    @Override
    public int hashCode() {

        return Objects.hash(patients);
    }


}
