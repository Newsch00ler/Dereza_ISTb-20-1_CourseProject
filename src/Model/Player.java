package Model;

public abstract class Player {
    protected String surname;
    protected String name;
    protected int number;

    public Player(String surname, String name, int number){
        this.surname = surname;
        this.name = name;
        this.number = number;
    }

    public String getSurname(){
        return surname;
    }

    public String getName(){
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
