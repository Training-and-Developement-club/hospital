package TheDevineHospital.TheCommandCenterOfThisProgramm;

import TheDevineHospital.DownloadFiles.URLDownload;
import TheDevineHospital.EntityClasses.Hospital;
import TheDevineHospital.EntityClasses.Patients.Gender;
import TheDevineHospital.EntityClasses.Patients.Patient;
import TheDevineHospital.EntityClasses.Patients.PatientList;
import TheDevineHospital.Exception.MissingFile;
import TheDevineHospital.Exception.MissingObject;
import TheDevineHospital.InputText.HelpInput;
import TheDevineHospital.ParseFile.HospitalParser.DOM;
import TheDevineHospital.ParseFile.HospitalParser.Jackson;
import TheDevineHospital.SearchPackage.SearchDoctorsByDate;
import TheDevineHospital.SearchPackage.SearchPatientByDate;
import TheDevineHospital.SearchPackage.SearchPatientByName;
import TheDevineHospital.SortPackage.SortByDate;
import TheDevineHospital.SortPackage.SortByName;
import TheDevineHospital.SortPackage.SortBySurname;

import java.io.File;
import java.util.Collections;

import static TheDevineHospital.SearchPackage.SearchDoctorsByName.search;

/* Пользовательский интерфейс
 * Класс является одиночкой (Singlton)
 * */
public class ControlCenter {
    private static Hospital hospital;
    private static ControlCenter center;
    private static PreparationForWork preparationForWork;

    private ControlCenter() {

    }


    public void controlCenter(ControlCenter cc) {
        //cc.automaticPrepareForWork();
        cc.manualPrepareForWork();

        //***********************ConvertToXml***************************
        PatientList patientList = PatientList.getInstance();
        patientList.getPatients().add(new Patient(patientList.getPatients().size() + 1, "Андрей", "Андреев", "Петоченко",
                "Болит колено", Gender.M,
                HelpInput.inputDate(), "Ушиб колено"));
        patientList.getPatients().add(new Patient(patientList.getPatients().size() + 1, "Лиана", "Игоревна", "Старевич",
                "Болит голень", Gender.F,
                HelpInput.inputDate(), "Открытый перелом голени"));
        //XmlConverter.convertToXml();

        cc.begginingOfWork();

    }

    private void automaticPrepareForWork() {
        preparationForWork = PreparationForWork.newInstance();
        preparationForWork.downloadAndParsingHospital();
        URLDownload.removeURLDownload();
        preparationForWork.uploadPatientHistory();
        PreparationForWork.removePreparationForWork();

    }

    private void manualPrepareForWork() {
        System.out.println("Ваши первые действия: " + "\n" +
                "1)Загрузить Xml больничку" + "\n" +
                "2)Загрузить Json больничку" + "\n" +
                "3)Десериализовать Xml" + "\n" +
                "4)Десериализовать Json" + "\n" +
                "5)Запустить программу");
        int input = 0;
        input = HelpInput.inputNumber();


        try {

            functionalManualPrapareForWork(input);

        } catch (MissingFile missingFile) {
            System.err.println(missingFile.getMessage());
            this.manualPrepareForWork();
        } catch (MissingObject missingObject) {
            System.err.println(missingObject.getMessage());
            this.manualPrepareForWork();
        }


    }

    private void functionalManualPrapareForWork(int input) throws MissingFile, MissingObject {
        switch (input) {
            case 1:
                URLDownload.getUrlDownload().downloadXml(URLDownload.LINK);
                this.manualPrepareForWork();
                break;

            case 2:
                URLDownload.getUrlDownload().downloadJson(URLDownload.LINK1);
                this.manualPrepareForWork();
                break;

            case 3:
                if (new File(URLDownload.getHospitalXML()).exists()) {
                    hospital = new DOM().parse(URLDownload.getHospitalXML());
                } else {
                    throw new MissingFile("Файл " + URLDownload.getHospitalXML() + " не найден. Попробуйте загрузить файл заново.");
                }
                this.manualPrepareForWork();
                break;

            case 4:
                if (new File(URLDownload.getHospitalJSON()).exists()) {
                    hospital = new Jackson().parse(URLDownload.getHospitalJSON());
                } else {
                    throw new MissingFile("Файл " + URLDownload.getHospitalJSON() + " не найден. Попробуйте загрузить файл заново.");
                }
                this.manualPrepareForWork();
                break;

            case 5:
                if (hospital == null) {
                    throw new MissingObject("Обьект больницы отсутствует, загрузите и десиреализуйте больничку xml или json");
                } else return;

            default:
                System.err.println("Некорректный ввод");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.manualPrepareForWork();
                break;
        }
    }


    private void begginingOfWork() {
        System.out.println("Что вы хотите сделать с докторами? : " + "\n" +
                "1)Найти доктора" + "\n" +
                "2)Сортировать докторов по..." + "\n" +
                "3)Найти пациента" + "\n" +
                "4)Сортировать пациентов по..." + "\n" +
                "5)Показать информацию о госпитале" + "\n" +
                "6)Поиграем? :D" + "\n" +
                "7).EXIT");
        int input = 0;
        input = HelpInput.inputNumber();
        letsGoMassage(input);

    }


    private void letsGoMassage(int input) {
        if (input == 1) {
            System.out.println("Найти доктора: " + "\n" +
                    "1)По имени" + "\n" +
                    "2)По дате рождения" + "\n");
            input = HelpInput.inputNumber();
            searchDoctorByArgument(input);

        } else if (input == 2) {
            System.out.println("Произвести сортировку докторов по: " + "\n" +
                    "1)Имени" + "\n" +
                    "2)Фамилии" + "\n" +
                    "3)Дате рождения");
            input = HelpInput.inputNumber();
            sortDoctorsByArgument(input);

        } else if (input == 3) {
            System.out.println("Найти пациента: " + "\n" +
                    "1)По имени" + "\n" +
                    "2)По дате рождения" + "\n");
            input = HelpInput.inputNumber();
            searchPatientByArgument(input);

        } else if (input == 4) {
            System.out.println("Произвести сортировку пациентов по: " + "\n" +
                    "1)Имени" + "\n" +
                    "2)Фамилии" + "\n" +
                    "3)Дате рождения");
            input = HelpInput.inputNumber();
            sortPatientByArgument(input);

        } else if (input == 5) {
            printInfoAboutHospital();

        } else if (input == 6) {
            //*********************************Ссылка на метод управления мини-игрой*********************************************
        } else if (input == 7) {
            System.out.println("Программа завершает работу...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(666);
        }
        begginingOfWork();
    }

    private void printInfoAboutHospital() {
        System.out.println(hospital.toString());
        System.out.println(PatientList.getInstance().toString());
    }

    private void sortPatientByArgument(int input) {
        Collections.sort(PatientList.getInstance().getPatients(),new SortByDate());
        
    }


    private void searchPatientByArgument(int input) {
        switch (input) {
            case 1:
                SearchPatientByName.search();
                break;
            case 2:
                SearchPatientByDate.search(PatientList.getInstance().getPatients());
                break;
            default:
                System.err.println("Некорректный ввод, попробуйте снова");
                searchPatientByArgument(HelpInput.inputNumber());
                break;

        }
    }

    private void searchDoctorByArgument(int input) {
        switch (input) {
            case 1:
                search(hospital);
                break;
            case 2:
                SearchDoctorsByDate.search(hospital.getDoctors());
                break;
            default:
                System.err.println("Некорректный ввод, попробуйте снова");
                searchDoctorByArgument(HelpInput.inputNumber());
                break;
        }

    }


    private void sortDoctorsByArgument(int input) {
        switch (input) {
            case 1:
                Collections.sort(hospital.getDoctors(), new SortByName());
                System.out.println("Результат сортировки:");
                System.out.println(hospital.getDoctors().toString());
                break;
            case 2:
                Collections.sort(hospital.getDoctors(), new SortBySurname());
                System.out.println("Результат сортировки:");
                System.out.println(hospital.getDoctors().toString());
                break;
            case 3:
                Collections.sort(hospital.getDoctors(), new SortByDate());
                System.out.println("Результат сортировки:");
                System.out.println(hospital.getDoctors().toString());
                break;
            default:
                System.err.println("Некорректный ввод, попробуйте снова");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.letsGoMassage(2);
                break;
        }
    }


    public static ControlCenter getInstance() {
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
