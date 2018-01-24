package TheDevineHospital.TheCommandCenterOfThisProgramm;

import TheDevineHospital.DownloadFiles.ChainIOfResponsibility.JsonMatchChain;
import TheDevineHospital.DownloadFiles.ChainIOfResponsibility.MatchString;
import TheDevineHospital.DownloadFiles.ChainIOfResponsibility.XmlMatchChain;
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
import TheDevineHospital.SortPackage.*;

import java.io.File;
import java.util.Collections;

import static TheDevineHospital.SearchPackage.SearchDoctorsByName.search;

/** Пользовательский интерфейс
 *  Класс является одиночкой (Singlton)
 * */
public class ControlCenter {
    public final String LINKXML = "http://kiparo.ru/t/hospital.xml";
    public final String LINKJSON = "http://kiparo.ru/t/hospital.json";
    private static Hospital hospital;
    private static ControlCenter center;
    private PreparationForWork preparationForWork;
    public static final String hospitalXML = "hospital.xml";
    public static final String hospitalJSON = "hospital.json";

    private ControlCenter() {

    }


    public void controlCenter(ControlCenter cc) {
        selectionOfProgramPreparation();

        //***********************ConvertToXml***************************
        /*PatientList patientList = PatientList.getInstance();
        patientList.getPatients().add(new Patient(patientList.getPatients().size() + 1, "Тимур", "Андреев", "Ягнёнок",
                "Болит колено", Gender.M,
                HelpInput.inputDate(), "Ушиб колено"));
        patientList.getPatients().add(new Patient(patientList.getPatients().size() + 1, "Лиана", "Игоревна", "Старевич",
                "Болит голень", Gender.F,
                HelpInput.inputDate(), "Открытый перелом голени"));*/

        begginingOfWork();

    }

    private void selectionOfProgramPreparation() {
        System.out.println("Выберете способ подготовки программы к работе: " + "\n" +
                "1)Автоматическая загрузки и распакова" + "\n" +
                "2)Загрузить и распаковать вручную");
        int input = 0;
        input = HelpInput.inputNumber();

        switch (input) {
            case 1:
                automaticPrepareForWork();
                break;
            case 2:
                manualPrepareForWork();
                break;
            default:
                System.err.println("Некорректный ввод, попробуйте снова:");
                selectionOfProgramPreparation();
                return;
        }
    }

    private void automaticPrepareForWork() {
        preparationForWork = PreparationForWork.newInstance();
        preparationForWork.downloadAndParsingHospital();
        preparationForWork.uploadPatientHistory();
        preparationForWork = null;
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
                MatchString xmlMatchChain = new XmlMatchChain();
                xmlMatchChain.checkProcess(LINKXML);
                this.manualPrepareForWork();
                break;

            case 2:
                MatchString jsonMatchChain = new JsonMatchChain();
                jsonMatchChain.checkProcess(LINKJSON);
                this.manualPrepareForWork();
                break;

            case 3:
                if (new File(hospitalXML).exists()) {
                    hospital = new DOM().parse(hospitalXML);
                } else {
                    throw new MissingFile("Файл " + hospitalXML + " не найден. Попробуйте загрузить файл заново.");
                }
                this.manualPrepareForWork();
                break;

            case 4:
                if (new File(hospitalJSON).exists()) {
                    hospital = new Jackson().parse(hospitalJSON);
                } else {
                    throw new MissingFile("Файл " + hospitalJSON + " не найден. Попробуйте загрузить файл заново.");
                }
                this.manualPrepareForWork();
                break;

            case 5:
                if (hospital == null) {
                    throw new MissingObject("Обьект больницы отсутствует, загрузите и десиреализуйте больничку xml или json");
                } else return;

            default:
                System.err.println("Некорректный ввод, попробуйте снова:");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.functionalManualPrapareForWork(HelpInput.inputNumber());
                break;
        }
    }


    private void begginingOfWork() {
        System.out.println("Что вы хотите? : " + "\n" +
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
            System.out.println("Сортировать докторов по: " + "\n" +
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
            System.out.println("Сортировать пациентов по: " + "\n" +
                    "1)Имени" + "\n" +
                    "2)Фамилии" + "\n" +
                    "3)Дате рождения");
            input = HelpInput.inputNumber();
            sortPatientByArgument(input);

        } else if (input == 5) {
            printInfoAboutHospital();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (input == 6) {
            //*********************************Ссылка на метод управления мини-игрой*********************************************
        } else if (input == 7) {
            System.out.println("Сохраняем изминения...");
            SaveInfo.saveAll();
            System.out.println("Программа завершает работу...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(666);
        } else {
            System.err.println("Некорректный ввод, попробуйте снова:");
            letsGoMassage(HelpInput.inputNumber());
            return;
        }
        begginingOfWork();
    }

    private void printInfoAboutHospital() {
        System.out.println(hospital.toString());
        System.out.println(PatientList.getInstance().toString());
    }

    private void sortPatientByArgument(int input) {
        if (PatientList.getInstance().getPatients() == null) {
            //throw new MissingObject("Нет информации о пользователях, попробуйте их создать, затем сортируйте.");
        } else {
            switch (input) {
                case 1:
                    Collections.sort(PatientList.getInstance().getPatients(), new SortPatientByName());
                    System.out.println("Результат сортировки:");
                    System.out.println(PatientList.getInstance().toString());
                    break;
                case 2:
                    Collections.sort(PatientList.getInstance().getPatients(), new SortPatientBySurname());
                    System.out.println("Результат сортировки:");
                    System.out.println(PatientList.getInstance().toString());
                    break;
                case 3:
                    Collections.sort(PatientList.getInstance().getPatients(), new SortByDate());
                    System.out.println("Результат сортировки:");
                    System.out.println(PatientList.getInstance().toString());
                    break;
                default:
                    System.err.println("Некорректный ввод, попробуйте снова:");
                    sortPatientByArgument(HelpInput.inputNumber());
                    break;
            }
        }
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
                System.err.println("Некорректный ввод, попробуйте снова:");
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
                System.err.println("Некорректный ввод, попробуйте снова:");
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
                System.err.println("Некорректный ввод, попробуйте снова:");
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