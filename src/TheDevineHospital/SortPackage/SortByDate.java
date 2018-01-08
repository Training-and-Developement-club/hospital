package TheDevineHospital.SortPackage;

import TheDevineHospital.EntityClasses.Doctors;
import TheDevineHospital.EntityClasses.People;

import java.util.Comparator;
import java.util.Date;

/*
 * @return Все мы знаем зачем нужен Компаратор
 * */
public class SortByDate implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
        Date date = o1.getDateOfBirth();
        Date date2 = o2.getDateOfBirth();

        return date.compareTo(date2);
    }
}
