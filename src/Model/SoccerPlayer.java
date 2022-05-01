package Model;

//https://www.liveresult.ru/football/players/Ronaldo-Cristiano

public class SoccerPlayer extends Player {
    protected String role;

    public SoccerPlayer(String surname, String name, String role, int number){
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
