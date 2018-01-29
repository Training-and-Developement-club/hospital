package hospital.manager.download.chain;

import hospital.manager.download.DownloadInterfaceCreator;
import hospital.manager.download.Downloader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonMatchChain extends MatchString {


    @Override
    public void checkProcess(String auditedUrl) {
        Pattern patternJSON = Pattern.compile("^http://((.)+)\\.(json)$");
        Matcher matcher = patternJSON.matcher(auditedUrl);
        if (matcher.matches()) {
            System.out.println("Корректный формат ссылки json");
            DownloadInterfaceCreator downloadInterfaceCreator = new DownloadInterfaceCreator.JsonDownloadCreator();
            Downloader jsonDownloader = downloadInterfaceCreator.createUrlDownloader();
            jsonDownloader.urlDownload("http://kiparo.ru/t/hospital.json");
        } else chain.checkProcess(auditedUrl);
    }

}
