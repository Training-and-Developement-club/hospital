package TheDevineHospital.DownloadFiles.Many_Threads;

import TheDevineHospital.DownloadFiles.URLDownload;
import TheDevineHospital.EntityClasses.Hospital;
import TheDevineHospital.ParseFile.DOM;
import TheDevineHospital.ParseFile.GsonParser;
import TheDevineHospital.ParseFile.Jackson;
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
            Hospital hospital = new DOM().parse(URLDownload.getHospitalXML());


            Object.class.notify();


            try {
                Object.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            System.out.println("Обрабатываю json");
             hospital = new Jackson().parse(URLDownload.getHospitalJSON());
             ControlCenter.setHospital(hospital);


            System.out.println("Проснись мы отработали, результат:");
            Object.class.notify();


        }

    }
}
