package TheDevineHospital.DownloadFiles;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class URLDownload {
    public static final String LINK = "http://kiparo.ru/t/hospital.xml";
    public static final String LINK1 = "http://kiparo.ru/t/hospital.json";
/*
* @return Принимает ссылку на документ json\xml и загружает её на локальный диск.
* */
    public static void download(String URLAdress) {
        try {
            URL url = new URL(URLAdress);
            if (URLAdress.equals(LINK)) {
                FileUtils.copyURLToFile(url, new File("hospital.xml"));
            } else if (URLAdress.equals(LINK1)) {
                FileUtils.copyURLToFile(url, new File("hospital.json"));
            } else throw new Exception("Кривая ссылка");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
