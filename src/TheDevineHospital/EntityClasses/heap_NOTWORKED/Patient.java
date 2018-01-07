package TheDevineHospital.EntityClasses.heap_NOTWORKED;


public abstract class Patient {

    protected String name;
    protected int age;
    protected String complaints;
    protected Gender gender;

    public abstract void say(String words);

    public Patient() {
    }

    public Patient(String name, int age, String complaints, Gender gender) {
        this.name = name;
        this.age = age;
        this.complaints = complaints;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", complaints='" + complaints + '\'' +
                ", gender=" + gender +
                '}';
    }
}
