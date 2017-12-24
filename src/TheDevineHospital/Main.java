package TheDevineHospital;

import TheDevineHospital.DownloadFiles.URLDownload;
import TheDevineHospital.EntityClasses.Hospital;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        URLDownload.download("http://kiparo.ru/t/hospital.xml");
        //URLDownload.download("http://kiparo.ru/t/hospital.json");
        ;
    }
}

