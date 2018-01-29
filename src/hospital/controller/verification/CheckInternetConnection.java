package hospital.controller.verification;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class CheckInternetConnection {
    public static boolean checkAdress(String adress) {
        try {
            URL url = new URL(adress);
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            Object objData = urlConnect.getContent();
        } catch (UnknownHostException e) {

            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
