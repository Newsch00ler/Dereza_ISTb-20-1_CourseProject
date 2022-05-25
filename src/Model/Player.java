package Model;

public abstract class Player {
    protected String surname;
    protected String name;
    protected int number;
    protected int mins;
    protected int goals;
    protected int assists;

    public Player(String name, String surname, int number, int mins, int goals, int assists){
        this.surname = surname;
        this.name = name;
        this.number = number;
        this.mins = mins;
        this.goals = goals;
        this.assists =assists;
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

    public int getMins() {
        return mins;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
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

    public void setMins(int mins) {
        this.mins = mins;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
}
