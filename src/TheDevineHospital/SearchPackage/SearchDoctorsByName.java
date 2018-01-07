package TheDevineHospital.SearchPackage;

import TheDevineHospital.EntityClasses.Hospital;
import TheDevineHospital.InputAndOutputText.HelpInput;
import TheDevineHospital.TheCommandCenterOfThisProgramm.ControlCenter;

/*
 * @return This class contains search methods by name for DOCTORS!!!
 */
public class SearchDoctorsByName {
    public static void search() {
        ControlCenter cc = new ControlCenter();
        Hospital hospital = cc.getHospital(); //Нарушение инкапсуляции? или нет? Если да - переделать.

        if (hospital.equals(null)) {
            System.err.println("Объект Hospital не найден");
            return;
        }

        System.out.println("Введите имя доктора:");
        String doc = HelpInput.inputString();
        int registor = 0;
        for (int i = 0; i < hospital.getDoctors().size(); i++) {
            if (doc.equalsIgnoreCase(hospital.getDoctors().get(i).getName())) {
                System.out.println("Найден доктор - " + hospital.getDoctors().get(i).toString());
                registor++;
            } else if (hospital.getDoctors().get(i).getName().contains(doc)) {
                System.out.println("Найдено совпадение - " + hospital.getDoctors().get(i).toString());
                registor++;
            }

        }


        if (registor == 0) {
            System.out.println("Совпадений не найдено");
        }

    }
}
