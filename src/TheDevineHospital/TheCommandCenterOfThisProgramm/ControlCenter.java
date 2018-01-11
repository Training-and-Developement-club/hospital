package TheDevineHospital.TheCommandCenterOfThisProgramm;

import TheDevineHospital.DownloadFiles.URLDownload;

import TheDevineHospital.EntityClasses.Hospital;
import TheDevineHospital.InputAndOutputText.HelpInput;

import TheDevineHospital.ParseFile.Jackson;
import TheDevineHospital.SearchPackage.SearchDoctorsByDate;
import TheDevineHospital.SortPackage.SortByDate;
import TheDevineHospital.SortPackage.SortByName;
import TheDevineHospital.SortPackage.SortBySurname;


import java.util.Collections;

import static TheDevineHospital.SearchPackage.SearchDoctorsByName.search;

/*
 * @return Пользовательский интерфейс
 *   ******************(переделать с gui!!!!)*******************
 * */
public class ControlCenter {
    private static Hospital hospital;
    private static ControlCenter center;





    public static void controlCenter() {
        ControlCenter cc = new ControlCenter();
        URLDownload.download("http://kiparo.ru/t/hospital.json");
        hospital = new Jackson().parse("hospital.json");
        //hospital = new DOM().parse("hospital.xml");
        System.out.println(hospital.getDoctors().toString());


        //System.out.println(string);
        /*MyGUI myGUI = new MyGUI();
        myGUI.goGui(hospital);*/


        cc.takeTheMassage();

    }

    public void takeTheMassage() {
        System.out.println("Что вы хотите сделать с докторами? : " + "\n" +
                "1)Найти доктора" + "\n" +
                "2)Сортировать по..." + "\n" +
                "3)Показать информацию о госпитале" + "\n" +
                "4).EXIT");
        letsGoMassage();
    }


    public void letsGoMassage() {
        int input = HelpInput.inputNumber();
        if (input == 1) {
            System.out.println("Найти: " + "\n" +
                    "1)По имени" + "\n" +
                    "2)По дате рождения" + "\n" +
                    "3)");
            input = HelpInput.inputNumber();
            if (input == 1) {
                search(hospital);
            } else if (input == 2) {
                SearchDoctorsByDate.search(hospital.getDoctors());
                takeTheMassage();
            }
        } else if (input == 2) {
            System.out.println("Произвести сортировку по: " + "\n" +
                    "1)Имени" + "\n" +
                    "2)Фамилии" + "\n" +
                    "3)Дате рождения");
            input = HelpInput.inputNumber();
            if (input == 1) {
                Collections.sort(hospital.getDoctors(), new SortByName());
                System.out.println("Результат сортировки:");
                System.out.println(hospital.getDoctors().toString());
            } else if (input == 2) {
                Collections.sort(hospital.getDoctors(), new SortBySurname());
                System.out.println("Результат сортировки:");
                System.out.println(hospital.getDoctors().toString());
            } else if (input == 3) {
                Collections.sort(hospital.getDoctors(), new SortByDate());
                System.out.println("Результат сортировки:");
                System.out.println(hospital.getDoctors().toString());
            } else takeTheMassage();
        } else if (input == 3) {
            System.out.println(hospital.toString());
            takeTheMassage();
        } else if (input == 4) {
            System.exit(666);
        } else takeTheMassage();
    }


    /*
     *@return This method use Singlton Pattern
     */
    public static ControlCenter newInstance() {
        if (center == null) {
            center = new ControlCenter();
        }
        return center;
    }

    public static Hospital getHospital() {
        return hospital;
    }

    public static void setHospital(Hospital hospital) {
        ControlCenter.hospital = hospital;
    }
}
