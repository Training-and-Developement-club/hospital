package TheDevineHospital.SortPackage;

import TheDevineHospital.EntityClasses.Doctors;
import TheDevineHospital.EntityClasses.People;

import java.util.Comparator;

/*
 * @return Все мы знаем зачем нужен Компаратор
 * */
public class SortBySurname implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
       int result = o1.getName().substring(o1.getName().indexOf(" ")).compareTo
               (o2.getName().substring(o2.getName().indexOf(" ")));

        return result;
    }


}
