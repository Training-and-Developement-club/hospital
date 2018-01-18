package TheDevineHospital.TheCommandCenterOfThisProgramm;

import TheDevineHospital.DownloadFiles.Many_Threads.ThreadDonwload;
import TheDevineHospital.DownloadFiles.Many_Threads.ThreadParsing;
import TheDevineHospital.EntityClasses.Hospital;
import TheDevineHospital.ParseFile.ConvertToXmlFromXml.XmlConverter;

/*
* Методам этого класса суждено подготовить программу к работе
* 1) Загрузка информации о госпитале для дальнейшей манипуляции с ней
* 2) Сохранение изменений
* */
public class PreparationForWork {


    public PreparationForWork(){

    }

    public void downloadAndParsingHospital(){
        ThreadDonwload threadDonwload = new ThreadDonwload();
        ThreadParsing threadParsing = new ThreadParsing();

        threadDonwload.setThreadParsing(threadParsing);
        threadParsing.setThreadDonwload(threadDonwload);
        threadParsing.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadDonwload.start();

        try {
            threadParsing.join();
            threadDonwload.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ControlCenter.getHospital());
    }

    public void uploadPatientHistory(){
        XmlConverter.convertFromXml();
    }




}
