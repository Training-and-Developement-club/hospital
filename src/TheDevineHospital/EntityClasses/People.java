package TheDevineHospital.EntityClasses;

import java.util.Date;
/*
* @return Абстрактный класс всех великих и могучих, и немножечко больных, представителей человеческой расы.
*         Делался для уменьшения кол-ва методов посредством полиморфических аргументов, наследования и т.д
* */
public abstract class People {
    protected int id;
    protected String name;
    protected String degree;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
