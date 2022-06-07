package Model;

public class HockeyPlayer extends Player {
    protected String stickGrip;
    protected int penaltyTime;
    protected int countPenalty;

    public HockeyPlayer(int ID, String name, String surname, int number, String role, String team, int mins, int goals, int assists, String stickGrip, int penaltyTime, int countPenalty){
        super(ID, name, surname, number, role, team, mins, goals, assists);
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
