package Model;

//https://www.liveresult.ru/basketball/players/Kobe-Bean-Bryant

public class BasketballPlayer extends Player {
    protected String role;

    public BasketballPlayer(String surname, String name, String role, int number){
        super(surname, name, number);
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
