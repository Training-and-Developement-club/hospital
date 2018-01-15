package TheDevineHospital;


import TheDevineHospital.InputAndOutputText.HelpInput;
import TheDevineHospital.TheCommandCenterOfThisProgramm.ControlCenter;

/*
* This class need for start the Devine Hospital.
*/

public class Main {

    public static void main(String[] args) {
        ControlCenter cc = ControlCenter.newInstance();
        ControlCenter.controlCenter(cc);

        //************json create*********************
        /*List<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Alex Skaszagrd",15,"Сломал ногу",M));
        patients.add(new Patient("Trisha Naggets",33,"Пробита ладонь гвоздём",F));
        patients.add(new Patient("Andry Jackman",42,"Опух локоть",M));
        PatientList pl = new PatientList();
        pl.setPatients(patients);
        System.out.println(pl.toString());
        try {
            Converter.converteToJson(pl);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        /*PatientList pl;
        try {

            pl = Converter.converterFromJson();
            System.out.println(pl.toString());
            Collections.sort(pl.getPatients(),new SortBySurname());
            System.out.println(pl.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
