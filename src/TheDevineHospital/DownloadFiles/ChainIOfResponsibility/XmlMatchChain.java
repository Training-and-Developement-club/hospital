package TheDevineHospital.DownloadFiles.ChainIOfResponsibility;

import TheDevineHospital.DownloadFiles.DownloadInterfaceCreator;
import TheDevineHospital.DownloadFiles.Downloader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlMatchChain extends MatchString {


    @Override
    public void checkProcess(String auditedUrl) {
        Pattern patternXML = Pattern.compile("^http://((.)+)\\.(xml)$");
        Matcher matcher = patternXML.matcher(auditedUrl);

        if (matcher.matches()) {
            System.out.println("Корректный формат ссылки xml");
            DownloadInterfaceCreator downloadInterfaceCreator = new DownloadInterfaceCreator.XmlDownloadCreator();
            Downloader xmlDownloader = downloadInterfaceCreator.createUrlDownloader();
            xmlDownloader.urlDownload(auditedUrl);
        } else chain.checkProcess(auditedUrl);
    }

}
