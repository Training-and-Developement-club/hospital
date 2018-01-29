package hospital.entity;

import java.util.List;
import java.util.Objects;

/**
 * Обьект больница.
 */
public class Hospital {
    private String name;
    private String location;
    private List<Doctors> doctors;

    @Override
    public String toString() {
        return "Информация о госпитале:  " + "\n" + "{" +
                "Госпиталь имени - '" + name + '\'' +
                ", место обитания'" + location + '\'' + "\n" +
                ", " + doctors +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hospital)) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(getName(), hospital.getName()) &&
                Objects.equals(getLocation(), hospital.getLocation()) &&
                Objects.equals(getDoctors(), hospital.getDoctors());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getLocation(), getDoctors());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctors> doctors) {
        this.doctors = doctors;
    }
}
