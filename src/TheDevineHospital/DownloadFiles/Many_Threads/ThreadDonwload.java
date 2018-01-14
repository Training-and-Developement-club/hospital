package TheDevineHospital.DownloadFiles.Many_Threads;

import TheDevineHospital.DownloadFiles.URLDownload;

public class ThreadDonwload extends Thread {
    private ThreadParsing threadParsing;

    public void setThreadParsing(ThreadParsing threadParsing) {
        this.threadParsing = threadParsing;
    }



    @Override
    public  void run() {


        synchronized (Object.class) {


            URLDownload.getUrlDownload().downloadXml(URLDownload.LINK);


            Object.class.notify();


            try {
                Object.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            URLDownload.getUrlDownload().downloadJson(URLDownload.LINK1);



            Object.class.notify();

        }


    }
}
