package TheDevineHospital.DownloadFiles;
/**
* Интерфейс фабрика
* */
public interface DownloadInterfaceCreator {
    Downloader createUrlDownloader();


    /**
     * Классы реализующие интерфейс DownloadInterfaceCreator для создания обьекта Donwloader.
     * @return new Downloader();
     * */
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


