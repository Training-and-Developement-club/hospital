package hospital.manager.download.threads;

import hospital.entity.Hospital;
import hospital.manager.parse.hospital.DOM;
import hospital.manager.parse.hospital.Jackson;
import hospital.manager.Manager;

/**
 * Класс потока десериализации
 */
public class ThreadParsing extends Thread {
    private ThreadDonwload threadDonwload;

    public void setThreadDonwload(ThreadDonwload threadDonwload) {
        this.threadDonwload = threadDonwload;
    }


    @Override
    public void run() {
        synchronized (Object.class) {
            try {
                Object.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Обрабатываю xml");
            Hospital hospital = new DOM().parse("hospital.xml");
            Object.class.notify();

            try {
                Object.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Обрабатываю json");
            hospital = new Jackson().parse("hospital.json");
            Manager.setHospital(hospital);


            Object.class.notify();


        }

    }
}
