package TheDevineHospital;


import TheDevineHospital.TheCommandCenterOfThisProgramm.ControlCenter;

/*
 * Класс мейн содержит метод "main" и используется только для запуска программы
 * Ещё это главный поток
 */

public class Main {

    public static void main(String[] args) {
        ControlCenter cc = ControlCenter.getInstance();
        cc.controlCenter(cc);
    }
}