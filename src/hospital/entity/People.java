package hospital.entity;



import java.util.Date;
/**
* Абстрактный класс всех великих и могучих, иногда больных, представителей человеческой расы.
*         Делался для уменьшения кол-ва методов посредством полиморфических аргументов, наследования и т.д
* */
public abstract class People {
    protected int id;
    protected String name;
    protected Date dateOfBirth;





    public abstract void say();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
