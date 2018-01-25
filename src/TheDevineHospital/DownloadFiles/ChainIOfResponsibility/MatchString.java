package TheDevineHospital.DownloadFiles.ChainIOfResponsibility;

/**
 * Паттерн Цепочка Обязанностей.
* */
public abstract class MatchString {
    protected MatchString chain;

    public abstract void checkProcess(String auditedUrl);

    public void nextChain(MatchString nextChain){
        this.chain = nextChain;
    }
}

