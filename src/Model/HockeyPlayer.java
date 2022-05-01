package Model;

//https://www.liveresult.ru/hockey/players/Alexander-Ovechkin

public class HockeyPlayer extends Player {
    protected String stickGrip;
    protected String role;

    public HockeyPlayer(String surname, String name, String role, int number, String stickGrip){
        super(surname, name, number);
        this.role = role;
        this.stickGrip = stickGrip;
    }

    public String getStickGrip() {
        return stickGrip;
    }

    public String getRole() {
        return role;
    }

    public void setStickGrip(String stickGrip) {
        this.stickGrip = stickGrip;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
