package hospital.manager.sort;


import hospital.entity.People;

import java.util.Comparator;
import java.util.Date;
/**
 * Интерфейс для упорядочивания обьектов класса People по дате рождения
 * */
public class SortPeopleByDate implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
        Date date = o1.getDateOfBirth();
        Date date2 = o2.getDateOfBirth();

        return date.compareTo(date2);
    }
}
