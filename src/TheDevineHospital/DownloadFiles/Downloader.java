package TheDevineHospital.DownloadFiles;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public interface Downloader {

    void urlDownload(String url);

}


class XmlDownloader implements Downloader {
    private String hospitalXML = "hospital.xml";

    @Override
    public void urlDownload(String xmlUrl) {

        try {
            URL url = new URL(xmlUrl);
            FileUtils.copyURLToFile(url, new File(hospitalXML));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("xml-загружен.");
    }
}



class JsonDownloader implements Downloader {
    private String hospitalJSON = "hospital.json";

    @Override
    public void urlDownload(String jsonUrl) {
        try {
            URL url = new URL(jsonUrl);
            FileUtils.copyURLToFile(url, new File(hospitalJSON));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("json-загружен.");
    }
}