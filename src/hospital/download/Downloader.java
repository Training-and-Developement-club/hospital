package hospital.download;

import hospital.controller.verification.CheckInternetConnection;
import hospital.controller.Manager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Downloader определяет общий интерфейс обьектов, которые может произвести Фабрика и его подклассы.
 */
public interface Downloader {

    void urlDownload(String url);

}


class XmlDownloader implements Downloader {
    private String hospitalXML = "hospital.xml";

    @Override
    public void urlDownload(String xmlUrl) {
        boolean checkResult = CheckInternetConnection.checkAdress(xmlUrl);
        if (checkResult) {
            try {
                URL url = new URL(xmlUrl);
                FileUtils.copyURLToFile(url, new File(hospitalXML));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("xml-загружен.");

        } else {
            System.err.println("Не получается подключиться к " + xmlUrl + ", проверьте подключение к интернету");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Manager.getInstance().startManager();
        }

    }
}


class JsonDownloader implements Downloader {
    private String hospitalJSON = "hospital.json";

    @Override
    public void urlDownload(String jsonUrl) {
        boolean checkResult = CheckInternetConnection.checkAdress(jsonUrl);
        if (checkResult) {
            try {
                URL url = new URL(jsonUrl);
                FileUtils.copyURLToFile(url, new File(hospitalJSON));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("json-загружен.");
        } else {
            System.err.println("Не получается подключиться к " + jsonUrl + ", проверьте подключение к интернету");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Manager.getInstance().startManager();
        }
    }

}