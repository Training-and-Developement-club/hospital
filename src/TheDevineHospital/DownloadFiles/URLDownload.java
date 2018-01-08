package TheDevineHospital.DownloadFiles;


import TheDevineHospital.RegularExpressionsAndAnonumusClasses.CheckURL;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLDownload {
    public static final String LINK = "http://kiparo.ru/t/hospital.xml";
    public static final String LINK1 = "http://kiparo.ru/t/hospital.json";
    private static String cheackLink;
/*
* @return Принимает ссылку на документ json\xml, проверяет её на соответствие шаблону регулярных выражений и анонимного класса и загружает её на локальный диск.
* */
    public static void download(String URLAdress) {
        cheackLink = URLAdress;
        checkURL(new CheckURL() {
            @Override
            public void checkURL(String StringURLAdress) {
                Pattern pattern = Pattern.compile("^http://((.)+)\\.(json|xml)$");
                Matcher matcher = pattern.matcher(StringURLAdress);
                if(matcher.matches()){
                    System.out.println("Корректный формат ссылки на json\\xml");
                }else System.out.println("Некорректный формат ссылки на файл, проверьте чтобы ссылка оканчивалась символами json\\xml");
            }
        });
        

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
    private static void checkURL(CheckURL checkURL){
        checkURL.checkURL(cheackLink);
    }


}
