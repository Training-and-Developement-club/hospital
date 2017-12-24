package TheDevineHospital.DownloadFiles;

import TheDevineHospital.ParseFile.Jackson;
import TheDevineHospital.ParseFile.DOM;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class URLDownload {
    public static final String LINK = "http://kiparo.ru/t/hospital.xml";
    public static final String LINK1 = "http://kiparo.ru/t/hospital.json";

    public static void download(String URLAdress) {
        try {
            URL url = new URL(URLAdress);
            if (URLAdress.equals(LINK)) {
                FileUtils.copyURLToFile(url, new File("hospital.xml"));
               new DOM().parse("hospital.xml");
            } else if (URLAdress.equals(LINK1)) {
                FileUtils.copyURLToFile(url, new File("hospital.json"));
                new Jackson().parse("hospital.json");
            } else throw new Exception("Кривая ссылка");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
