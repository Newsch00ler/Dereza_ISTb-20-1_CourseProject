package Model;

//!!!https://www.liveresult.ru/hockey/players/Alexander-Ovechkin

public class HockeyPlayer extends Player {
    protected String stickGrip; //хват
    protected int penaltyTime; //время нарушений
    protected int countPenalty; //кол-во нарушений

    public HockeyPlayer(String name, String surname, String role, String team, int number, String stickGrip, int mins, int goals, int assists, int penaltyTime, int countPenalty){
        super(surname, name, number, role, team, mins, goals, assists);
        this.stickGrip = stickGrip;
        this.penaltyTime = penaltyTime;
        this.countPenalty = countPenalty;
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
