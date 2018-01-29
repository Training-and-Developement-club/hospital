package hospital.input;


import hospital.exception.DateFormatException;
import hospital.exception.FormatIntegerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/*
 * Класс содержит методы ввода: целого числа\строки\даты с консоли.
 */
public class HelpInput {
    private static final String TIMEZONE_UTC = "UTC";
    private static Date date;


    //@return Строку введённую с консоли
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
        String input = "";
        int result = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            result = Integer.parseInt(input);
        } catch (Exception e) {
            try {
                throw new FormatIntegerException("Неверный формат введённых данных, введите целое число:");
            } catch (FormatIntegerException e1) {
                System.err.println(e1.getMessage());
            }
            result = inputNumber();
        }

        return result;
    }


    /*Принимает пользовательский ввод даты и возвращаем её в метод для последующих операций.
     * @return Дату в UTC
     * */
    public static Date inputDate() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату рождения человека в формате dd-MM-yyyy (25-12-2000)");
        String input = "";
        SimpleDateFormat simpleDateFormat = null;
        Date date = null;
        try {
            //Следующие 3 строчки устанавливают формат и часовой пояс для введённых пользователем данных о дате рождения.
            simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            TimeZone timeZone = TimeZone.getTimeZone(TIMEZONE_UTC);
            simpleDateFormat.setTimeZone(timeZone);
            input = bufferedReader.readLine();
            try {
                date = simpleDateFormat.parse(input);
            } catch (Exception e) {
                try {
                    throw new DateFormatException("Неверный формат даты, введите по образцу:");
                } catch (DateFormatException e1) {
                    System.err.println(e1.getMessage());
                    return inputDate();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return date;
    }

}
