package TheDevineHospital.DownloadFiles.ChainIOfResponsibility;


public abstract class MatchString {
    protected MatchString chain;

    public abstract void checkProcess(String auditedUrl);

    public void nextChain(MatchString nextChain){
        this.chain = nextChain;
    }
}

