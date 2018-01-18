package TheDevineHospital.EntityClasses.Patients;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



/*
*  Здесь, в (List<Patient> patients) хранится список всех пациентов, которые уже есть и которых вы ещё не добавили)
*/
public class PatientList {
    private List<Patient> patients = new ArrayList<>();
    private static PatientList patientList;
    private PatientList(){

    }

    /*
    * @return Единственный нужный обьект пациентов.
    * */
    public static PatientList getInstance(){
        if(patientList == null){
            patientList = new PatientList();
            }
        return patientList;
    }






    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
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
