package Model;

//???https://www.liveresult.ru/football/players/Ronaldo-Cristiano
//???https://1xbet.whoscored.com/Players/300713/Show/Kylian-Mbappé


public class SoccerPlayer extends Player {
    protected String role; //амплуа
    protected String team;
    protected int yelCard; //жетлые карточки
    protected int redCard; //красные карточки
    protected int psPerc; //процент успешных передач

    public SoccerPlayer(String name, String surname, String role, String team, int number, int mins, int goals, int assists, int yelCard, int redCard, int psPerc){
        super(surname, name, number, mins, goals, assists);
        this.role = role;
        this.team = team;
        this.yelCard = yelCard;
        this.redCard = redCard;
        this.psPerc = psPerc;
    }

    public String getRole() {
        return role;
    }
    public String getTeam() {
        return team;
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

    public void setRole(String role) {
        this.role = role;
    }
    public void setTeam(String team) {
        this.team = team;
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
