package hospital.manager.sort;


import hospital.entity.People;

import java.util.Comparator;

/**
 * Интерфейс для упорядочивания обьектов класса People по имени
 * */
public class SortDoctorsByName implements Comparator<People> {


    @Override
    public int compare(People o1, People o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        return name1.compareTo(name2);
    }


}
