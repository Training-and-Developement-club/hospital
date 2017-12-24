package TheDevineHospital.SortPackage;

import TheDevineHospital.EntityClasses.Doctors;
import TheDevineHospital.EntityClasses.Hospital;

import java.util.Comparator;

public class SortByName implements Comparator<Doctors>{


    @Override
    public int compare(Doctors o1, Doctors o2) {
     String name1 = o1.getName();
     String name2 = o2.getName();
        return name1.compareTo(name2);
    }


}
