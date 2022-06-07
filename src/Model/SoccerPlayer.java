package Model;

public class SoccerPlayer extends Player {
    protected int yelCard;
    protected int redCard;
    protected int psPerc;

    public SoccerPlayer(int ID, String name, String surname, int number, String role, String team,  int mins, int goals, int assists, int yelCard, int redCard, int psPerc){
        super(ID, name, surname, number, role, team, mins, goals, assists);
        this.yelCard = yelCard;
        this.redCard = redCard;
        this.psPerc = psPerc;
    }

    public int getYelCard() {
        return yelCard;
    }
    public int getRedCard() {
        return redCard;
    }
    public int getPsPerc() {
        return psPerc;
    }

    public void setYelCard(int yelCard) {
        this.yelCard = yelCard;
    }
    public void setRedCard(int redCard) {
        this.redCard = redCard;
    }
    public void setPsPerc(int psPerc) {
        this.psPerc = psPerc;
    }
}
