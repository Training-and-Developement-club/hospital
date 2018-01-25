package TheDevineHospital.SortPackage;


import TheDevineHospital.EntityClasses.People;

import java.util.Comparator;

/**
 * Интерфейс для упорядочивания обьектов класса People по фамилии
 * */
public class SortDoctorsBySurname implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
        int result = o1.getName().substring(o1.getName().indexOf(" ")).compareTo
                (o2.getName().substring(o2.getName().indexOf(" ")));

        return result;
    }


}
