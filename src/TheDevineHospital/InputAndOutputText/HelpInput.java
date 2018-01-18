package TheDevineHospital.InputAndOutputText;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/*
 * This class contains all input operations.
 */
public class HelpInput {
    private static final String TIMEZONE_UTC = "UTC";
    private static Date date;


    //@return Строку введённую на консоли
    public static String inputString() {
        String result = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //@return Целочисленное значение ввведённое с консоли
    public static int inputNumber() {
        int result = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            result = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /*Принимает пользовательский ввод даты и возвращаем её в метод для последующих операций.
     * @return Дату в UTC
     * */
    public static Date inputDate() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату рождения человека в формате dd-MM-yyyy (25-12-2000)");

        SimpleDateFormat simpleDateFormat = null;
        Date date = null;
        try {
            //Следующие 3 строчки устанавливают формат и часовой пояс для введённых пользователем данных о дате рождения.
            simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            TimeZone timeZone = TimeZone.getTimeZone(TIMEZONE_UTC);
            simpleDateFormat.setTimeZone(timeZone);
            date = simpleDateFormat.parse(bufferedReader.readLine());
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return date;
    }

}
