package TheDevineHospital.SortPackage;


import TheDevineHospital.EntityClasses.People;

import java.util.Comparator;

/**
 *  Сортировка пиплов по имени
 * */
public class SortByName implements Comparator<People> {


    @Override
    public int compare(People o1, People o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        return name1.compareTo(name2);
    }


}
