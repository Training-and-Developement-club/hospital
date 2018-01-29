package hospital;


import hospital.manager.Manager;
import hospital.manager.search.SearchPatientByName;

/**
 * Класс Main содержит метод "main" и используется только для запуска программы
 * Ещё это главный поток
 */

public class Main {

    public static void main(String[] args) {
        Manager cc = Manager.getInstance();
        cc.startManager();


    }
}