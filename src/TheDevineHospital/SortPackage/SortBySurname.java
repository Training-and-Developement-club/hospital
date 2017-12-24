package TheDevineHospital.SortPackage;

import TheDevineHospital.EntityClasses.Doctors;

import java.util.Comparator;

public class SortBySurname implements Comparator<Doctors> {
    @Override
    public int compare(Doctors o1, Doctors o2) {
       int result = o1.getName().substring(o1.getName().indexOf(" ")).compareTo
               (o2.getName().substring(o2.getName().indexOf(" ")));

        return result;
    }
}
