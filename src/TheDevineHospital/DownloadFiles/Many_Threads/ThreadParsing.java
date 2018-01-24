package TheDevineHospital.DownloadFiles.Many_Threads;

import TheDevineHospital.EntityClasses.Hospital;
import TheDevineHospital.ParseFile.HospitalParser.DOM;
import TheDevineHospital.ParseFile.HospitalParser.Jackson;
import TheDevineHospital.TheCommandCenterOfThisProgramm.ControlCenter;

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
            ControlCenter.setHospital(hospital);


            Object.class.notify();


        }

    }
}
