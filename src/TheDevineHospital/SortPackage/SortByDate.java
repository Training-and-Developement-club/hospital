package TheDevineHospital.SortPackage;

import TheDevineHospital.EntityClasses.Doctors;

import java.util.Comparator;
import java.util.Date;

public class SortByDate implements Comparator<Doctors>{
    @Override
    public int compare(Doctors o1, Doctors o2) {
        Date date = o1.getDateOfBirth();
        Date date2 = o2.getDateOfBirth();

        return date.compareTo(date2);
    }
}
