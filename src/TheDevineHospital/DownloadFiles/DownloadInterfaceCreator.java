package TheDevineHospital.DownloadFiles;

public interface DownloadInterfaceCreator {
    Downloader createUrlDownloader();
    class XmlDownloadCreator implements DownloadInterfaceCreator{

        @Override
        public Downloader createUrlDownloader() {
            return new XmlDownloader();
        }
    }
    class JsonDownloadCreator implements DownloadInterfaceCreator{

        @Override
        public Downloader createUrlDownloader() {
            return new JsonDownloader();
        }
    }
}


