package Model;

//!!!https://www.liveresult.ru/hockey/players/Alexander-Ovechkin

public class HockeyPlayer extends Player {
    protected String role; //амплуа
    protected String team; //команда
    protected String stickGrip; //хват
    protected int penaltyTime; //время нарушений
    protected int countPenalty; //кол-во нарушений

    public HockeyPlayer(String name, String surname, String role, String team, int number, String stickGrip, int mins, int goals, int assists, int penaltyTime, int countPenalty){
        super(surname, name, number, mins, goals, assists);
        this.role = role;
        this.team = team;
        this.stickGrip = stickGrip;
        this.penaltyTime = penaltyTime;
        this.countPenalty = countPenalty;
    }

    public String getRole() {
        return role;
    }
    public String getTeam() {
        return team;
    }
    public String getStickGrip() {
        return stickGrip;
    }
    public int getPenaltyTime() {
        return penaltyTime;
    }
    public int getCountPenalty() {
        return countPenalty;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public void setStickGrip(String stickGrip) {
        this.stickGrip = stickGrip;
    }
    public void setPenaltyTime(int penaltyTime) {
        this.penaltyTime = penaltyTime;
    }
    public void setCountPenalty(int countPenalty) {
        this.countPenalty = countPenalty;
    }
}
