package TheDevineHospital;


import TheDevineHospital.TheCommandCenterOfThisProgramm.ControlCenter;

/*
 * Класс мейн содержит метод "main" и используется только для запуска программы
 */

public class Main {

    public static void main(String[] args) {
        ControlCenter cc = ControlCenter.getInstance();
        cc.controlCenter(cc);
    }
}