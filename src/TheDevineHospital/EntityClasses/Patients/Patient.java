package TheDevineHospital.EntityClasses.Patients;


import TheDevineHospital.EntityClasses.People;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Patient extends People {
    private int id;
    private Map<String,String> fullName = new HashMap<>();
    private int age;
    private String complaints;
    private Gender gender;
    private Date dateOfbirthday;
    private String diseases; //Результат осмотра у доктора. (Заболевание пациента)
    private boolean isAlive = true;
    public Patient() {
    }



    public Patient(int id, String firstName, String surName,String lastName, String complaints, Gender gender, Date dateOfbirthday, String diseases) {
        this.id = id;
        this.fullName.put("Имя", firstName);
        this.fullName.put("Отчество", surName);
        this.fullName.put("Фамилия", lastName);
        this.complaints = complaints;
        this.gender = gender;
        this.dateOfbirthday = dateOfbirthday;
        this.diseases = diseases;
    }
    private static void totalAge(){//*******************************************************************age from dateOfbirthday
    }




    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", age=" + age +
                ", complaints='" + complaints + '\'' +
                ", gender=" + gender +
                ", dateOfbirthday=" + dateOfbirthday +
                ", diseases='" + diseases + '\'' +
                ", isAlive=" + isAlive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getId() == patient.getId() &&
                getAge() == patient.getAge() &&
                isAlive() == patient.isAlive() &&
                Objects.equals(getFullName(), patient.getFullName()) &&
                Objects.equals(getComplaints(), patient.getComplaints()) &&
                getGender() == patient.getGender() &&
                Objects.equals(getDateOfbirthday(), patient.getDateOfbirthday()) &&
                Objects.equals(getDiseases(), patient.getDiseases());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFullName(), getAge(), getComplaints(), getGender(), getDateOfbirthday(), getDiseases(), isAlive());
    }

    @Override
    public void say() {
        System.out.println("Hello");
    }


    public Map<String, String> getFullName() {
        return fullName;
    }

    public void setFullName(Map<String, String> fullName) {
        this.fullName = fullName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
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
