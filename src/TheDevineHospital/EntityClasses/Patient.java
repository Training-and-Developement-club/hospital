package TheDevineHospital.EntityClasses;


import TheDevineHospital.EntityClasses.heap_NOTWORKED.Gender;

import java.util.Date;
import java.util.Objects;

public class Patient extends People{
    private int id;
    private String name;
    private int age;
    private String complaints;
    private Gender gender;
    private Date dateOfbirthday;
    private String diseases; //Результат осмотра у доктора. (Заболевание пациента)

    public Patient() {
    }

    public Patient(String name, int age, String complaints, Gender gender) {
        this.name = name;
        this.age = age;
        this.complaints = complaints;
        this.gender = gender;
    }

    public Patient(String name, int age, String complaints, Gender gender, Date dateOfbirthday) {
        this.name = name;
        this.age = age;
        this.complaints = complaints;
        this.gender = gender;
        this.dateOfbirthday = dateOfbirthday;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", complaints='" + complaints + '\'' +
                ", gender=" + gender +
                ", dateOfbirthday=" + dateOfbirthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                age == patient.age &&
                Objects.equals(name, patient.name) &&
                Objects.equals(complaints, patient.complaints) &&
                gender == patient.gender &&
                Objects.equals(dateOfbirthday, patient.dateOfbirthday);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age, complaints, gender, dateOfbirthday);
    }

    @Override
    public void say() {
        System.out.println("Hello");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfbirthday() {
        return dateOfbirthday;
    }

    public void setDateOfbirthday(Date dateOfbirthday) {
        this.dateOfbirthday = dateOfbirthday;
    }
}
