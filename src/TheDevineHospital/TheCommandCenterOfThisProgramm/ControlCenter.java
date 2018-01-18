package TheDevineHospital.TheCommandCenterOfThisProgramm;

import TheDevineHospital.DownloadFiles.Many_Threads.ThreadDonwload;
import TheDevineHospital.DownloadFiles.Many_Threads.ThreadParsing;
import TheDevineHospital.EntityClasses.Hospital;
import TheDevineHospital.EntityClasses.Patients.Gender;
import TheDevineHospital.EntityClasses.Patients.Patient;
import TheDevineHospital.EntityClasses.Patients.PatientList;
import TheDevineHospital.InputAndOutputText.HelpInput;
import TheDevineHospital.ParseFile.ConvertToXmlFromXml.XmlConverter;
import TheDevineHospital.SearchPackage.SearchDoctorsByDate;
import TheDevineHospital.SortPackage.SortByDate;
import TheDevineHospital.SortPackage.SortByName;
import TheDevineHospital.SortPackage.SortBySurname;

import java.util.Collections;

import static TheDevineHospital.SearchPackage.SearchDoctorsByName.search;

/* Пользовательский интерфейс
 *   ******************(переделать с gui!!!!)*******************
 * */
public class ControlCenter {
    private static Hospital hospital;
    private static ControlCenter center;
    private static PreparationForWork preparationForWork;
    private ControlCenter(){

    }




    public void controlCenter(ControlCenter cc) {
        preparationForWork = new PreparationForWork();
        preparationForWork.downloadAndParsingHospital();
        //preparationForWork.uploadPatientHistory();

        //***********************ConvertToXml***************************
        PatientList patientList = PatientList.newInstance();
        patientList.getPatients().add(new Patient(patientList.getPatients().size()+1, "Андрей", "Андреев", "Петоченко",
                "Болит колено", Gender.M,
                HelpInput.inputDate(),"Ушиб колено"));
        patientList.getPatients().add(new Patient(patientList.getPatients().size()+1, "Лиана", "Игоревна", "Старевич",
                "Болит голень", Gender.F,
                HelpInput.inputDate(),"Открытый перелом голени"));
        XmlConverter.convertToXml();

        cc.begginingOfWork();

    }
    





    public void begginingOfWork() {
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
                begginingOfWork();
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
            } else begginingOfWork();
        } else if (input == 3) {
            System.out.println(hospital.toString());
            begginingOfWork();
        } else if (input == 4) {
            System.exit(666);
        } else begginingOfWork();
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
