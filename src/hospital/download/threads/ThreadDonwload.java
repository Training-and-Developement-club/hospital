package hospital.download.threads;

import hospital.download.chain.JsonMatchChain;
import hospital.download.chain.MatchString;
import hospital.download.chain.XmlMatchChain;
/**
 * Класс потока загрузки
 * */
public class ThreadDonwload extends Thread {
    private ThreadParsing threadParsing;

    public void setThreadParsing(ThreadParsing threadParsing) {
        this.threadParsing = threadParsing;
    }



    @Override
    public  void run() {


        synchronized (Object.class) {
            MatchString xmlMatchChain = new XmlMatchChain();
            xmlMatchChain.checkProcess("http://kiparo.ru/t/hospital.xml");
            Object.class.notify();

            try {
                Object.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MatchString jsonMatchChain = new JsonMatchChain();
            jsonMatchChain.checkProcess("http://kiparo.ru/t/hospital.json");
            Object.class.notify();

        }


    }
}
