package TheDevineHospital.DownloadFiles;


import TheDevineHospital.InputAndOutputText.HelpInput;
import TheDevineHospital.RegularExpressionsAndAnonumusClasses.CheckURL;
import TheDevineHospital.RegularExpressionsAndAnonumusClasses.FixLinkOnFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLDownload {
    public static final String LINK = "http://kiparo.ru/t/hospital.xml";
    public static final String LINK1 = "http://kiparo.ru/t/hospital.json";
    private static String cheackLink;
    private static URLDownload urlDownload;
    /*
     * @return Принимает ссылку на документ json\xml, проверяет её на соответствие шаблону регулярных выражений и анонимного класса и загружает её на локальный диск.
     * */

    public static void download(String URLAdress) {






        cheackLink = URLAdress;

        checkURL(new CheckURL() {//Спросить для этого участка кода правильно ли решение добавить анонимный класс

            @Override
            public void checkURL(String StringURLAdress) {
                Pattern patternJSON = Pattern.compile("^http://((.)+)\\.(json)$");
                Pattern patternXML = Pattern.compile("^http://((.)+)\\.(xml)$");
                Matcher matcher = patternJSON.matcher(StringURLAdress);
                Matcher matcher1 = patternXML.matcher(StringURLAdress);
                if (matcher.matches()) {
                    System.out.println("Корректный формат ссылки json");
                    try {
                        URL url = new URL(URLAdress);
                        FileUtils.copyURLToFile(url, new File("hospital.json"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (matcher1.matches()) {
                    System.out.println("Корректный формат ссылки xml");
                    try {
                        URL url = new URL(URLAdress);
                        FileUtils.copyURLToFile(url, new File("hospital.xml"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Некорректный формат ссылки на файл");
                    System.out.println("Попробуйте ввести ссылку вручную:");//************** Убрать или переделать? а может оставить************
                    fixLinkOnFile(new FixLinkOnFile() {//своего рода зацикливание до тех пор, пока не будет передана нормальная ссылка)))
                        @Override
                        public void fix() {
                             String gogoNewURL = HelpInput.inputString();
                            download(gogoNewURL);
                        }
                    });
                }
            }
        });



    }

    /*
    * @return use Singlton
    * */
    public static URLDownload newInstance(){
        if(urlDownload==null){
            urlDownload = new URLDownload();
        }
        return urlDownload;
    }


    private static void fixLinkOnFile(FixLinkOnFile fixLinkOnFile) {
        fixLinkOnFile.fix();
    }

    private static void checkURL(CheckURL checkURL) {
        checkURL.checkURL(cheackLink);
    }


}
