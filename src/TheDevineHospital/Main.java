package TheDevineHospital;

import TheDevineHospital.DownloadFiles.URLDownload;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        URLDownload.download("http://kiparo.ru/t/hospital.xml");
        //URLDownload.download("http://kiparo.ru/t/hospital.json");

    }
}

