package Model;

public abstract class Person {
    protected String surname;
    protected String name;

    public String getSurname(){
        return surname;
    }

    public String getName(){
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }
}
