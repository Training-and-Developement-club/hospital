package hospital.entity.Patients;


import hospital.entity.People;

import java.util.*;

/**
 * Обьект пациент
 */
public class Patient extends People {
    private Map<String, String> fullName = new HashMap<>();
    private String complaints;
    private int age;
    private Gender gender;
    private String diseases; //Результат осмотра у доктора. (Заболевание пациента)
    private boolean isAlive = true;

    public Patient() {

    }


    public Patient(int id, String firstName, String surName, String lastName, String complaints, Gender gender, Date dateOfBirth, String diseases) {
        this.id = id;
        this.fullName.put("Имя", firstName);
        this.fullName.put("Отчество", surName);
        this.fullName.put("Фамилия", lastName);
        this.complaints = complaints;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.diseases = diseases;
        this.age = CalculatePatientsAge.totalAge(dateOfBirth);

    }

    public Patient(int id, String firstName, String surName, String lastName, String complaints, Gender gender, Date dateOfBirth, String diseases, boolean isAlive) {
        this.id = id;
        this.fullName.put("Имя", firstName);
        this.fullName.put("Отчество", surName);
        this.fullName.put("Фамилия", lastName);
        this.complaints = complaints;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.diseases = diseases;
        this.isAlive = isAlive;
        this.age = CalculatePatientsAge.totalAge(dateOfBirth);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getAge() == patient.getAge() &&
                isAlive() == patient.isAlive() &&
                Objects.equals(getFullName(), patient.getFullName()) &&
                Objects.equals(getComplaints(), patient.getComplaints()) &&
                getGender() == patient.getGender() &&
                Objects.equals(getDiseases(), patient.getDiseases());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFullName(), getComplaints(), getAge(), getGender(), getDiseases(), isAlive());
    }

    @Override
    public String toString() {
        return "\t" + "Patient{" +
                fullName +
                ", симптомы '" + complaints + '\'' +
                ", возраст: " + age +
                ", пол: " + gender +
                ", заболевания: '" + diseases + '\'' +
                ", жив: " + isAlive +
                ", id: " + id +
                ", Дата рождения: " + dateOfBirth +
                '}' + "\n";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
