package TheDevineHospital.EntityClasses.heap_NOTWORKED;




public class Male extends Patient {

    @Override
    public String toString() {
        return "Male{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", complaints='" + complaints + '\'' +
                ", gender=" + gender +
                '}';
    }


    public Male(String name, int age, String complaints, Gender gender) {
        this.name = name;
        this.age = age;
        this.complaints = complaints;
        this.gender = gender;
    }



    @Override
    public void say(String words) {

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
}
