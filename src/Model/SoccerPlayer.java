package Model;

//???https://www.liveresult.ru/football/players/Ronaldo-Cristiano
//???https://1xbet.whoscored.com/Players/300713/Show/Kylian-Mbappé


public class SoccerPlayer extends Player {
    protected String role; //амплуа
    protected String team;
    protected int mins; //минуты на поле
    protected int goals; //голы
    protected int assists; //ассисты
    protected int yelCard; //жетлые карточки
    protected int redCard; //красные карточки
    protected int psPerc; //процент успешных передач

    public SoccerPlayer(String surname, String name, String role, String team, int number, int mins, int goals, int assists, int yelCard, int redCard, int psPerc){
        super(surname, name, number);
        this.role = role;
        this.team = team;
        this.mins = mins;
        this.goals = goals;
        this.assists = assists;
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
    public int getMins() {
        return mins;
    }
    public int getGoals() {
        return goals;
    }
    public int getAssists() {
        return assists;
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
    public void setMins(int mins) {
        this.mins = mins;
    }
    public void setGoals(int goals) {
        this.goals = goals;
    }
    public void setAssists(int assists) {
        this.assists = assists;
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
