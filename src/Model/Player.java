package Model;

public abstract class Player {
    protected int ID;
    protected String surname;
    protected String name;
    protected int number;
    protected String role;
    protected String team;
    protected int mins;
    protected int goals;
    protected int assists;

    public Player(int ID, String name, String surname, int number, String role, String team, int mins, int goals, int assists){
        this.ID = ID;
        this.surname = surname;
        this.name = name;
        this.number = number;
        this.role = role;
        this.team= team;
        this.mins = mins;
        this.goals = goals;
        this.assists =assists;
    }

    public int getID() { return ID; }

    public String getSurname(){
        return surname;
    }

    public String getName(){
        return name;
    }

    public String getFullName(){
        return name + " " + surname;
    }

    public int getNumber() {
        return number;
    }

    public String getRole() {
        return role;
    }

    public String getTeam() {
        return team;
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

    public void setID(int ID) { this.ID = ID; }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setTeam(String team) {
        this.team = team;
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
